package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var rollButtom: Button
    private lateinit var resultText: TextView
    private lateinit var diceImageView : ImageView

    /*
    lateinit es una palabra clave en Kotlin que se usa para indicar que una variable no nullable
    (no nula) no será inicializada en el momento de su declaración, pero se garantiza
    que se inicializará antes de que se acceda a su valor por primera vez.*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollButtom = findViewById(R.id.rollButton)
        resultText = findViewById(R.id.resultText)
        diceImageView = findViewById(R.id.diceImageView)

        diceImageView.setBackgroundResource(R.drawable.empty_dice)

        rollButtom.setOnClickListener {
            val randomNumber = (1..6).random()
            val rotationAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation)

            rotationAnimation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}

                override fun onAnimationEnd(animation: Animation?) {
                    when (randomNumber) {
                        1 -> diceImageView.setBackgroundResource(R.drawable.dice_1)
                        2 -> diceImageView.setBackgroundResource(R.drawable.dice_2)
                        3 -> diceImageView.setBackgroundResource(R.drawable.dice_3)
                        4 -> diceImageView.setBackgroundResource(R.drawable.dice_4)
                        5 -> diceImageView.setBackgroundResource(R.drawable.dice_5)
                        6 -> diceImageView.setBackgroundResource(R.drawable.dice_6)
                    }

                    resultText.text = randomNumber.toString()
                }

                override fun onAnimationRepeat(animation: Animation?) {}

            })

            diceImageView.startAnimation(rotationAnimation)
        }

    }
}