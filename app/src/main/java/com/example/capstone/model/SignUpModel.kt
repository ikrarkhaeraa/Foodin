package com.example.capstone.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstone.response.SignUpResponse
import kotlinx.coroutines.launch

class SignUpModel(private val data: DataSource) : ViewModel() {
    val signUp: LiveData<SignUpResponse> = data.signUp

    fun postDataSignUp(email:String, password:String, weightCurrent: Int, height:Int, gender:String,
                       age:Int, goals:String) {
        viewModelScope.launch {
            data.uploadSignUpData(email, password, weightCurrent, height,
                gender, age, goals)
        }
    }
}