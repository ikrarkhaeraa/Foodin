package com.example.capstone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstone.R
import com.example.capstone.databinding.ActivityGoalsBinding

class GoalsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGoalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoalsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        chooseButton()
    }

    private fun chooseButton() {
        binding.apply {
            blueRectangle.setOnClickListener {
                val intentToNextPage = Intent(this@GoalsActivity, CurrentWeightActivity::class.java)
                intentToNextPage.putExtra("DATA", "Gain Weight")
                startActivity(intentToNextPage)
            }
            blueRectangle2.setOnClickListener {
                val intentToNextPage = Intent(this@GoalsActivity, CurrentWeightActivity::class.java)
                intentToNextPage.putExtra("DATA", "Maintain Weight")
                startActivity(intentToNextPage)
            }
            blueRectangle3.setOnClickListener {
                val intentToNextPage = Intent(this@GoalsActivity, CurrentWeightActivity::class.java)
                intentToNextPage.putExtra("DATA", "Loss Weight")
                startActivity(intentToNextPage)
            }
        }
    }

}