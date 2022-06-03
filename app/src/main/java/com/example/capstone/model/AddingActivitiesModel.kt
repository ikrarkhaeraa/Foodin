package com.example.capstone.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstone.response.AddingActivitiesResponse
import kotlinx.coroutines.launch

class AddingActivitiesModel(private val data: DataSource) : ViewModel() {
    val addingActivitiesModel: LiveData<AddingActivitiesResponse> = data.add

    fun postDataAdding(token:String, activityName:String, duration:Int) {
        viewModelScope.launch {
            data.addingActivities(token, activityName, duration)
        }
    }
}