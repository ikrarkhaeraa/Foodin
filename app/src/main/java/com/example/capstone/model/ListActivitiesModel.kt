package com.example.capstone.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.capstone.response.ListActivitiesResponse

class ListActivitiesModel(private val data: DataSource) : ViewModel() {
    val listActivities: LiveData<ListActivitiesResponse> = data.listActivities
}