package com.example.capstone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstone.databinding.ActivityCurrentHeightBinding
import com.example.capstone.databinding.ActivityCurrentWeightBinding

class CurrentHeightActivity : AppCompatActivity() {

    companion object {
        const val PASSWORD = "password"
        const val EMAIL = "email"
        const val GOALS = "goals"
        const val WEIGHT = "weight"
    }

    private lateinit var binding: ActivityCurrentHeightBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCurrentHeightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var currentWeight = binding.currentHeight
        var numberPicker = binding.numberPicker
        numberPicker.minValue = 0
        numberPicker.maxValue = 300
        numberPicker.value = 150
        numberPicker.wrapSelectorWheel = true

        numberPicker.setOnValueChangedListener {
                _, _, newValue -> currentWeight.text = "YOUR CURRENT HEIGHT IS: $newValue"

            binding.buttonNext.setOnClickListener {
                var email = intent.getStringExtra(EMAIL)
                var password = intent.getStringExtra(PASSWORD)
                var goals = intent.getStringExtra(GOALS)
                var weight = intent.getStringExtra(WEIGHT)
                val intentToNextPage = Intent(this@CurrentHeightActivity, CurrentAgeActivity::class.java)
                intentToNextPage.putExtra(CurrentAgeActivity.EMAIL, password)
                intentToNextPage.putExtra(CurrentAgeActivity.PASSWORD, email)
                intentToNextPage.putExtra(CurrentAgeActivity.GOALS, goals)
                intentToNextPage.putExtra(CurrentAgeActivity.WEIGHT, weight)
                intentToNextPage.putExtra(CurrentAgeActivity.HEIGHT, newValue)
                startActivity(intentToNextPage)
            }

        }


    }
}