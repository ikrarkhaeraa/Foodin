package com.example.capstone.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.capstone.ModelFactory
import com.example.capstone.R
import com.example.capstone.databinding.ActivityGenderBinding
import com.example.capstone.model.SignUpModel

class GenderActivity : AppCompatActivity() {

    companion object {
        const val PASSWORD = "password"
        const val EMAIL = "email"
        const val GOALS = "goals"
        const val WEIGHT = "weight"
        const val HEIGHT = "height"
        const val AGE = "age"
    }

    private lateinit var binding: ActivityGenderBinding
    private lateinit var factory: ModelFactory
    private val model: SignUpModel by viewModels { factory }

    @SuppressLint("SetTextI18n")
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
            var gender = newValue.toString()

            binding.buttonNext.setOnClickListener {
                var email = intent.getStringExtra(EMAIL)
                var password = intent.getStringExtra(PASSWORD)
                var goals = intent.getStringExtra(GOALS)
                var weight = intent.getIntExtra(WEIGHT, 0)
                var height = intent.getIntExtra(HEIGHT, 0)
                var age = intent.getIntExtra(AGE, 0)
                if (email?.isNotEmpty() == true && password?.isNotEmpty() == true && goals?.isNotEmpty() == true &&
                    weight?.toString().isNotEmpty() == true && height?.toString().isNotEmpty() == true && age?.toString().isNotEmpty() == true && gender.isNotEmpty()
                ) {
                    model.postDataSignUp(
                        email.toString(),
                        password.toString(),
                        height,
                        weight,
                        gender,
                        age,
                        goals.toString()
                    )
                    moveToLogin()
                }
            }
        }
    }

    private fun moveToLogin () {
        model.signUp.observe(this@GenderActivity) { response ->
            if (response.status.equals(true)) {
                val intent = Intent(this@GenderActivity, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

}