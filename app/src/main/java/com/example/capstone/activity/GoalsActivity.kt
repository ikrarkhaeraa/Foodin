package com.example.capstone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstone.databinding.ActivityGoalsBinding

class GoalsActivity : AppCompatActivity() {

    companion object {
        const val NAME = "name"
        const val PASSWORD = "password"
        const val EMAIL = "email"
    }

    private lateinit var binding: ActivityGoalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoalsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        chooseButton()
    }

    private fun chooseButton() {
        val name = intent.getStringExtra(NAME)
        val email = intent.getStringExtra(EMAIL)
        val password = intent.getStringExtra(PASSWORD)
        binding.apply {
            blueRectangle.setOnClickListener {
                val intentToNextPage = Intent(this@GoalsActivity, CurrentWeightActivity::class.java)
                intentToNextPage.putExtra(CurrentWeightActivity.NAME, name)
                intentToNextPage.putExtra(CurrentWeightActivity.EMAIL, email)
                intentToNextPage.putExtra(CurrentWeightActivity.PASSWORD, password)
                intentToNextPage.putExtra(CurrentWeightActivity.GOALS, "gain")
                startActivity(intentToNextPage)
            }
            blueRectangle2.setOnClickListener {
                val intentToNextPage = Intent(this@GoalsActivity, CurrentWeightActivity::class.java)
                intentToNextPage.putExtra(CurrentWeightActivity.NAME, name)
                intentToNextPage.putExtra(CurrentWeightActivity.EMAIL, email)
                intentToNextPage.putExtra(CurrentWeightActivity.PASSWORD, password)
                intentToNextPage.putExtra(CurrentWeightActivity.GOALS, "maintain")
                startActivity(intentToNextPage)
            }
            blueRectangle3.setOnClickListener {
                val intentToNextPage = Intent(this@GoalsActivity, CurrentWeightActivity::class.java)
                intentToNextPage.putExtra(CurrentWeightActivity.NAME, name)
                intentToNextPage.putExtra(CurrentWeightActivity.EMAIL, email)
                intentToNextPage.putExtra(CurrentWeightActivity.PASSWORD, password)
                intentToNextPage.putExtra(CurrentWeightActivity.GOALS, "loss")
                startActivity(intentToNextPage)
            }
        }
    }

}