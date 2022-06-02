package com.example.capstone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstone.R
import com.example.capstone.databinding.ActivityGenderBinding

class GenderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGenderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var currentWeight = binding.gender
        var numberPicker = binding.numberPicker
        var gender = resources.getStringArray(R.array.gender)
        numberPicker.displayedValues = gender
        numberPicker.minValue = 0
        numberPicker.maxValue = 1
        numberPicker.wrapSelectorWheel = true

        numberPicker.setOnValueChangedListener {
                _, _, newValue -> currentWeight.text = "YOUR CURRENT AGE IS: " + gender[newValue]
        }
    }

}