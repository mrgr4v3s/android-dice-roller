package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var rollButton: Button
    lateinit var resultImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    private fun setupView() {
        rollButton = findViewById(R.id.roll_button)
        resultImage = findViewById(R.id.dice_image)

        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val drawableResource: Int = when (generateRandomNumberBetweenOneAndSix()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        resultImage.setImageResource(drawableResource)
    }

    private fun generateRandomNumberBetweenOneAndSix(): Int {
        return Random().nextInt(6) + 1
    }
}
