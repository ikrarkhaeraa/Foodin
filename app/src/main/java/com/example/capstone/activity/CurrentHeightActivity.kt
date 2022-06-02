package com.example.capstone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstone.databinding.ActivityCurrentHeightBinding
import com.example.capstone.databinding.ActivityCurrentWeightBinding

class CurrentHeightActivity : AppCompatActivity() {

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
                val intentToNextPage = Intent(this@CurrentHeightActivity, CurrentAgeActivity::class.java)
                intentToNextPage.putExtra("DATA", newValue)
                startActivity(intentToNextPage)
            }

        }


    }
}