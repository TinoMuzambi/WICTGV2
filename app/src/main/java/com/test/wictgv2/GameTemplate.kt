package com.test.wictgv2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_game_template.*

class GameTemplate : AppCompatActivity() {

    override fun onStop() {
        super.onStop()
        gameIsActive = false
    }

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
    
    fun runGame(images : Array<Int>, objects : Array<Car>) {
        option1Button.setImageResource(images[0])
        option2Button.setImageResource(images[1])

        var counter=0
        var counter1=1

        option1Button.setOnClickListener{
            val message = if (objects[counter].price<objects[counter1].price) {
                "You got it right!."
            } else {
                "You got it wrong!. It was the "+objects[counter1].name+"."
            }
            val snackbar = Snackbar.make(game_template,message, Snackbar.LENGTH_LONG)
            snackbar.show()
            if (counter1==7) {
                counter1=1
                counter=0
            }
            else {
                counter+=2
                counter1+=2
            }
            option1Button.setImageResource(images[counter])
            option2Button.setImageResource(images[counter1])
        }

        option2Button.setOnClickListener{
            val message = if (objects[counter1].price<objects[counter].price) {
                "You got it right!."
            } else {
                "You got it wrong!. It was the "+objects[counter].name+"."
            }
            val snackbar = Snackbar.make(game_template,message, Snackbar.LENGTH_LONG)
            snackbar.show()
            if (counter1==7) {
                counter1=1
                counter=0
            }
            else {
                counter+=2
                counter1+=2
            }
            option1Button.setImageResource(images[counter])
            option2Button.setImageResource(images[counter1])
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_template)
        gameIsActive = true
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
