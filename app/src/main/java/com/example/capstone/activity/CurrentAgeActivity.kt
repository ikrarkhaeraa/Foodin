package com.example.capstone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstone.databinding.ActivityCurrentAgeBinding

class CurrentAgeActivity : AppCompatActivity() {

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
                val intentToNextPage = Intent(this@CurrentAgeActivity, GenderActivity::class.java)
                intentToNextPage.putExtra("DATA", newValue)
                startActivity(intentToNextPage)
            }

        }

    }
}