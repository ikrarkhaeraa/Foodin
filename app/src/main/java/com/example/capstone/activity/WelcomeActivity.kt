package com.example.capstone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstone.databinding.ActivityMainBinding
import com.example.capstone.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        chooseButton()
    }

    private fun chooseButton() {
        binding.apply {
            signUp.setOnClickListener {
                val intentToSignUp = Intent(this@WelcomeActivity, SignUpActivity::class.java)
                startActivity(intentToSignUp)
            }
            signIn.setOnClickListener {
                val intentToSignIn = Intent(this@WelcomeActivity, SignInActivity::class.java)
                startActivity(intentToSignIn)
            }
        }
    }

}