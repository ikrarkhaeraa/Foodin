package com.example.capstone.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstone.api.SignInResponse
import kotlinx.coroutines.launch

class SignInModel(private val data: DataSource) : ViewModel() {
    val signIn: LiveData<SignInResponse> = data.signIn

    fun postDataSignIn(email:String, password:String) {
        viewModelScope.launch {
            data.uploadSignInData(email, password)
        }
    }
}