package com.example.capstone.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
        factory = ModelFactory.getInstance(this)
        setContentView(binding.root)

        val currentWeight = binding.gender
        val numberPicker = binding.numberPicker
        val chooseGender = resources.getStringArray(R.array.gender)
        numberPicker.displayedValues = chooseGender
        numberPicker.minValue = 0
        numberPicker.maxValue = 1
        numberPicker.wrapSelectorWheel = true

        numberPicker.setOnValueChangedListener {
                _, _, newValue -> currentWeight.text = "YOUR GENDER IS: " + chooseGender[newValue]
            val gender = chooseGender[newValue]
            val email = intent.getStringExtra(EMAIL)
            val password = intent.getStringExtra(PASSWORD)
            val goals = intent.getStringExtra(GOALS)
            val weight = intent.getIntExtra(WEIGHT, 0)
            val height = intent.getIntExtra(HEIGHT, 0)
            val age = intent.getIntExtra(AGE, 0)

            Log.d("cekData", "$email")
            Log.d("cekData", "$password")
            Log.d("cekData", "$goals")
            Log.d("cekData", "$weight")
            Log.d("cekData", "$height")
            Log.d("cekData", "$age")
            Log.d("cekData", gender)

            binding.buttonNext.setOnClickListener {
                if (email?.isNotEmpty() == true && password?.isNotEmpty() == true &&
                    goals?.isNotEmpty() == true && weight?.toString().isNotEmpty() &&
                    height?.toString().isNotEmpty() && age?.toString().isNotEmpty() && gender.isNotEmpty()
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
               } else {
                    Toast.makeText(applicationContext,"please input your gender", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun moveToLogin () {
        model.signUp.observe(this@GenderActivity) { response ->
                val intent = Intent(this@GenderActivity, SignInActivity::class.java)
                startActivity(intent)
        }
    }

//    private fun showLoading(isLoading: Boolean) {
//        if (isLoading) {
//            binding.progressBar.visibility = View.VISIBLE
//        } else {
//            binding.progressBar.visibility = View.GONE
//        }
//    }

}