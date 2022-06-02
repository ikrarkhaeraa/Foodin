package com.example.capstone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstone.R
import com.example.capstone.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    companion object {
        private const val FIELD_REQUIRED = "Cannot Be Empty"
        private const val FIELD_IS_NOT_VALID = "Invalid Email"
    }

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickButton()
    }

    private fun clickButton() {
        binding.apply {
            val email = binding.edtEmail.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()
            signIn.setOnClickListener {
                if (email.isEmpty() && password.isEmpty() && isValidEmail(email)) {
                    edtEmail.error = FIELD_IS_NOT_VALID
                    edtPassword.error = FIELD_REQUIRED
                } else {
                    moveToNextPage()
                }
            }
        }
    }

    private fun isValidEmail(email: CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun moveToNextPage () {
        binding.apply {
            signIn.setOnClickListener {
                val intentToSignUp = Intent(this@SignInActivity, MainActivity::class.java)
                startActivity(intentToSignUp)
            }
        }
    }

}