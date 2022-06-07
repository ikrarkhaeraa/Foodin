package com.example.capstone.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstone.response.ListActivitiesResponse
import kotlinx.coroutines.launch

class ListActivitiesModel(private val data: DataSource) : ViewModel() {
    val listActivities: LiveData<ListActivitiesResponse> = data.listActivities

    fun getListActivity() {
        viewModelScope.launch {
            data.getListActivities()
            Log.d("listActivity", "$listActivities")
        }
    }
}