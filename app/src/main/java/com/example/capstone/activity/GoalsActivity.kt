package com.example.capstone.activity

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
    }
}