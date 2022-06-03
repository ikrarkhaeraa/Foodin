package com.example.capstone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.capstone.ModelFactory
import com.example.capstone.databinding.ActivitySignInBinding
import com.example.capstone.model.SignInModel
import com.example.capstone.model.SignUpModel
import com.example.capstone.model.UserSession

class SignInActivity : AppCompatActivity() {

    companion object {
        private const val FIELD_REQUIRED = "Cannot Be Empty"
        private const val FIELD_IS_NOT_VALID = "Invalid Email"
    }

    private lateinit var binding: ActivitySignInBinding
    private lateinit var factory: ModelFactory
    private val model: SignInModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        factory = ModelFactory.getInstance(this)

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
                    uploadData()
                    model.userLogin()
                    moveToNextPage()
                }
            }
        }
    }

    private fun isValidEmail(email: CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun saveUserSession(session: UserSession){
        model.saveUserSession(session)
    }

    private fun uploadData() {
        binding.apply {
            model.postDataSignIn(
                edtEmail.text.toString(),
                edtPassword.text.toString()
            )
        }
        model.signIn.observe(this@SignInActivity) { response ->
            saveUserSession(
                UserSession(
                    response.data.token,
                    true
                )
            )
        }
    }

    private fun moveToNextPage () {
        model.signIn.observe(this@SignInActivity) {
                val intent = Intent(this@SignInActivity, MainActivity::class.java)
                startActivity(intent)
        }
    }

}