package com.example.capstone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.capstone.databinding.ActivityCurrentAgeBinding

class CurrentAgeActivity : AppCompatActivity() {

    companion object {
        const val NAME = "name"
        const val PASSWORD = "password"
        const val EMAIL = "email"
        const val GOALS = "goals"
        const val WEIGHT = "weight"
        const val HEIGHT = "height"
    }

    private lateinit var binding: ActivityCurrentAgeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCurrentAgeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var currentWeight = binding.currentAge
        var numberPicker = binding.numberPicker
        numberPicker.minValue = 0
        numberPicker.maxValue = 100
        numberPicker.value = 21
        numberPicker.wrapSelectorWheel = true

        numberPicker.setOnValueChangedListener {
                _, _, newValue -> currentWeight.text = "YOUR CURRENT AGE IS: $newValue"

            binding.buttonNext.setOnClickListener {
                val name = intent.getStringExtra(NAME)
                val email = intent.getStringExtra(EMAIL)
                val password = intent.getStringExtra(PASSWORD)
                val goals = intent.getStringExtra(GOALS)
                val weight = intent.getIntExtra(WEIGHT, 0)
                val height = intent.getIntExtra(HEIGHT, 0)
                if (newValue.toString().isEmpty()) {
                    Toast.makeText(applicationContext,"please input your age", Toast.LENGTH_SHORT).show()
                } else {
                    val intentToNextPage = Intent(this@CurrentAgeActivity, GenderActivity::class.java)
                    intentToNextPage.putExtra(GenderActivity.NAME, name)
                    intentToNextPage.putExtra(GenderActivity.EMAIL, email)
                    intentToNextPage.putExtra(GenderActivity.PASSWORD, password)
                    intentToNextPage.putExtra(GenderActivity.GOALS, goals)
                    intentToNextPage.putExtra(GenderActivity.WEIGHT, weight)
                    intentToNextPage.putExtra(GenderActivity.HEIGHT, height)
                    intentToNextPage.putExtra(GenderActivity.AGE, newValue)
                    startActivity(intentToNextPage)
                }
            }
        }
    }
}