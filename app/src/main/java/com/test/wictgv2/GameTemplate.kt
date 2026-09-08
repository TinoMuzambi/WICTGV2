package com.test.wictgv2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_game_template.*

class GameTemplate : AppCompatActivity() {

    private val cars = arrayOf(
        Car(270000, "Alfa Romeo Mito"),
        Car(2395000, "Aston Martin Vanquish"),
        Car(300000, "Audi A1"),
        Car(30000000, "Bugatti Veyron"),
        Car(1000000, "Bentley Continental GT Sport"),
        Car(360000, "BMW X3"),
        Car(250000, "Cadillac Escalade"),
        Car(1000000, "Chevrolet Camaro")
    )

    private val images = arrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8
    )

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
    
    private fun runGame() {
        option1Button.setImageResource(images[0])
        option2Button.setImageResource(images[1])

        var counter=0
        var counter1=1

        option1Button.setOnClickListener{
            val message = if (cars[counter].price < cars[counter1].price) {
                "You got it right!"
            } else {
                "You got it wrong! It was the ${cars[counter1].name}."
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
            val message = if (cars[counter1].price < cars[counter].price) {
                "You got it right!"
            } else {
                "You got it wrong! It was the ${cars[counter].name}."
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
        runGame()
    }
}
