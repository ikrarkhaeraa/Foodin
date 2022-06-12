package com.example.capstone.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstone.data.entity.ActivityEntity
import com.example.capstone.response.AddingActivitiesResponse
import kotlinx.coroutines.launch

class AddingActivitiesModel(private val data: DataSource) : ViewModel() {
    val addingActivitiesModel: LiveData<AddingActivitiesResponse> = data.add

    fun deleteActivity(id: String) {
        viewModelScope.launch {
            data.deleteActivity(id)
        }
    }

    fun getActivity() : List<ActivityEntity>? {
        var activityName : List<ActivityEntity>? = null
        viewModelScope.launch {
            activityName = data.getActivity()
        }
        return activityName
    }

    fun postDataAdding(token:String, id:String, activityName: String, duration: Int) {
        viewModelScope.launch {
            data.addingActivities(token, id, activityName, duration)
        }
    }
}