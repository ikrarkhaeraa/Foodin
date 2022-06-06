package com.example.capstone.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstone.response.CalorieResponse
import kotlinx.coroutines.launch

class CalorieModel(private val data: DataSource) : ViewModel() {
     val calorie: LiveData<CalorieResponse> = data.getCalorie

    fun checkCalorie() {
        Log.e("calorie", "$calorie")
    }

    fun getCalorie(token: String, id: String) {
        viewModelScope.launch {
            data.getCalorie(token, id)
            Log.e("token", "onResponse: $token")
            Log.e("userId", "onResponse: $id")
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