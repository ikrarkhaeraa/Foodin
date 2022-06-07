package com.example.capstone.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstone.data.entity.ActivityEntity
import com.example.capstone.response.AddingActivitiesResponse
import kotlinx.coroutines.launch

class AddingActivitiesModel(private val data: DataSource) : ViewModel() {
    val addingActivitiesModel: LiveData<AddingActivitiesResponse> = data.add

    fun getBookmarked() = data.getBookmarked()

    fun save(added: ActivityEntity) {
        data.setBookmarked(added, true)
    }

    fun delete(added: ActivityEntity) {
        data.setBookmarked(added, false)
    }

    fun postDataAdding(token:String, activityName:String, duration:Int) {
        viewModelScope.launch {
            data.addingActivities(token, activityName, duration)
        }
    }
}