package com.example.capstone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.capstone.databinding.ActivityCurrentWeightBinding

class CurrentWeightActivity : AppCompatActivity() {

    companion object {
        const val NAME = "name"
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
                val name = intent.getStringExtra(NAME)
                val email = intent.getStringExtra(EMAIL)
                val password = intent.getStringExtra(PASSWORD)
                val goals = intent.getStringExtra(GOALS)
                if (newValue.toString().isEmpty()) {
                    Toast.makeText(applicationContext,"please input your weight",Toast.LENGTH_SHORT).show()
                } else {
                    val intentToNextPage = Intent(this@CurrentWeightActivity, CurrentHeightActivity::class.java)
                    intentToNextPage.putExtra(CurrentHeightActivity.NAME, name)
                    intentToNextPage.putExtra(CurrentHeightActivity.EMAIL, email)
                    intentToNextPage.putExtra(CurrentHeightActivity.PASSWORD, password)
                    intentToNextPage.putExtra(CurrentHeightActivity.GOALS, goals)
                    intentToNextPage.putExtra(CurrentHeightActivity.WEIGHT, newValue)
                    startActivity(intentToNextPage)
                }
            }

        }

    }
}