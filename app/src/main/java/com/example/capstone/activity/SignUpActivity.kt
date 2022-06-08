package com.example.capstone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.capstone.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    companion object {
        private const val FIELD_REQUIRED = "Cannot Be Empty"
        private const val FIELD_IS_NOT_VALID = "Invalid Email"
    }

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickButton()
    }

    private fun clickButton() {
        binding.apply {
            val name = binding.edtName.text.toString().trim()
            val email = binding.edtEmail.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()
            signUp.setOnClickListener {
                if (name.isEmpty() && email.isEmpty() && password.isEmpty() && isValidEmail(email)) {
                    edtName.error = FIELD_REQUIRED
                    edtEmail.error = FIELD_IS_NOT_VALID
                    edtPassword.error = FIELD_REQUIRED
                } else {
                    val intentToNextPage = Intent(this@SignUpActivity, GoalsActivity::class.java)
                    intentToNextPage.putExtra(GoalsActivity.NAME, edtName.text.toString())
                    intentToNextPage.putExtra(GoalsActivity.EMAIL, edtEmail.text.toString())
                    intentToNextPage.putExtra(GoalsActivity.PASSWORD, edtPassword.text.toString())
                    startActivity(intentToNextPage)
                }
            }
        }
    }

    private fun isValidEmail(email: CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}