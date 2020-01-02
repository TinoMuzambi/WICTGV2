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
    val car1 = Car(270000,"Alfa Romeo Mito")
    val car2 = Car(2395000,"Aston Martin Vanquish")
    val car3 = Car(300000,"Audi A1")
    val car4 = Car(30000000,"Bugatti Veyron")
    val car5 = Car(1000000,"Bentley Continental GT Sport")
    val car6 = Car(360000,"BMW X3")
    val car7 = Car(250000,"Cadillac Escalade")
    val car8 = Car(1000000,"Chevrolet Camaro")

    val images = arrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8)

    val cars = arrayOf(car1,car2,car3,car4,car5,car6,car7,car8)

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
            GameTemplate().runGame(images,cars)
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
