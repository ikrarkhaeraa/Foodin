package com.example.capstone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstone.databinding.ActivityCurrentAgeBinding

class CurrentAgeActivity : AppCompatActivity() {

    companion object {
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
                var email = intent.getStringExtra(EMAIL)
                var password = intent.getStringExtra(PASSWORD)
                var goals = intent.getStringExtra(GOALS)
                var weight = intent.getStringExtra(WEIGHT)
                var height = intent.getStringExtra(HEIGHT)
                val intentToNextPage = Intent(this@CurrentAgeActivity, GenderActivity::class.java)
                intentToNextPage.putExtra(GenderActivity.EMAIL, password)
                intentToNextPage.putExtra(GenderActivity.PASSWORD, email)
                intentToNextPage.putExtra(GenderActivity.GOALS, goals)
                intentToNextPage.putExtra(GenderActivity.WEIGHT, weight)
                intentToNextPage.putExtra(GenderActivity.HEIGHT, height)
                intentToNextPage.putExtra(GenderActivity.AGE, newValue)
                startActivity(intentToNextPage)
            }

        }

    }
}