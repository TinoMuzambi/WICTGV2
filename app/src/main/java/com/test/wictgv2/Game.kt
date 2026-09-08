package com.test.wictgv2

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.ScrollView
import kotlinx.android.synthetic.main.activity_game.*
var gameIsActive = false

class Game : AppCompatActivity(){
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_game -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_dashboard -> {
                val intent = Intent(this,Dashboard::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_settings -> {
                val intent = Intent(this,Settings::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onResume() {
        super.onResume()
        gameIsActive = false
        buttonScrollView.visibility = ScrollView.VISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        carButton.setOnClickListener {
            val snackbar = Snackbar.make(game_view,"Car category",Snackbar.LENGTH_SHORT)
            buttonScrollView.visibility = ScrollView.INVISIBLE
            val intent = Intent(this,GameTemplate::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(intent)
            gameIsActive = true
            snackbar.show()
        }

        houseButton.setOnClickListener {
            val snackbar = Snackbar.make(game_view,"House category",Snackbar.LENGTH_SHORT)
            gameIsActive = true
            snackbar.show()
        }

        personButton.setOnClickListener {
            val snackbar = Snackbar.make(game_view,"Person category",Snackbar.LENGTH_SHORT)
            gameIsActive = true
            snackbar.show()
        }

        thingButton.setOnClickListener {
            val snackbar = Snackbar.make(game_view,"Thing category",Snackbar.LENGTH_SHORT)
            gameIsActive = true
            snackbar.show()
        }

        foodButton.setOnClickListener {
            val snackbar = Snackbar.make(game_view,"Food category",Snackbar.LENGTH_SHORT)
            gameIsActive = true
            snackbar.show()
        }
    }

}
