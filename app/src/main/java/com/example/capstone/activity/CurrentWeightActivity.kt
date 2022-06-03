package com.example.capstone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstone.databinding.ActivityCurrentWeightBinding

class CurrentWeightActivity : AppCompatActivity() {

    companion object {
        const val PASSWORD = "password"
        const val EMAIL = "email"
        const val GOALS = "goals"
    }

    private lateinit var binding: ActivityCurrentWeightBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCurrentWeightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var currentWeight = binding.currentWeight
        var numberPicker = binding.numberPicker
        numberPicker.minValue = 0
        numberPicker.maxValue = 200
        numberPicker.value = 60
        numberPicker.wrapSelectorWheel = true

        numberPicker.setOnValueChangedListener {
                _, _, newValue -> currentWeight.text = "YOUR CURRENT WEIGHT IS: $newValue"
            
            binding.buttonNext.setOnClickListener {
                var email = intent.getStringExtra(EMAIL)
                var password = intent.getStringExtra(PASSWORD)
                var goals = intent.getStringExtra(GOALS)
                val intentToNextPage = Intent(this@CurrentWeightActivity, CurrentHeightActivity::class.java)
                intentToNextPage.putExtra(CurrentHeightActivity.EMAIL, password)
                intentToNextPage.putExtra(CurrentHeightActivity.PASSWORD, email)
                intentToNextPage.putExtra(CurrentHeightActivity.GOALS, goals)
                intentToNextPage.putExtra(CurrentHeightActivity.WEIGHT, newValue)
                startActivity(intentToNextPage)
            }

        }

    }
}