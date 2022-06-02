package com.example.capstone.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.capstone.response.FoodListResponse
import com.example.capstone.response.ListActivitiesResponse

class FoodListModel(private val data: DataSource) : ViewModel() {
    val foodList: LiveData<FoodListResponse> = data.getFood
}