package com.example.capstone.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstone.response.CalorieResponse
import kotlinx.coroutines.launch

class CalorieModel(private val data: DataSource) : ViewModel() {
    val calorie: LiveData<CalorieResponse> = data.getCalorie

    fun getCalorie(token: String) {
        viewModelScope.launch {
            data.getCalorie(token)
            Log.e("token", "onResponse: $token")
        }
    }

    fun getUserSession(): LiveData<UserSession> {
        return data.getUserSession()
    }

    fun userLogout() {
        viewModelScope.launch {
            data.userLogout()
        }
    }

}