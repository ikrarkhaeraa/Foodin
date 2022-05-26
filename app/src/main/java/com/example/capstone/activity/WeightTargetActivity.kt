package com.example.capstone.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstone.databinding.ActivityMainBinding
import com.example.capstone.databinding.ActivityWeightTargetBinding

class WeightTargetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeightTargetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeightTargetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var weightTargetCapt = binding.weightTarget
        var numberPicker = binding.numberPicker
        numberPicker.minValue = 0
        numberPicker.maxValue = 200
        numberPicker.value = 60
        numberPicker.wrapSelectorWheel = true

        numberPicker.setOnValueChangedListener {
                _, _, newValue -> weightTargetCapt.text = "YOUR WEIGHT TARGET IS: $newValue"
        }
    }
}