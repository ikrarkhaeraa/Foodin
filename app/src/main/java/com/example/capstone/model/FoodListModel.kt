package com.example.capstone.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstone.response.FoodListsResponse
import com.example.capstone.response.ListActivitiesResponse
import kotlinx.coroutines.launch

class FoodListModel(private val data: DataSource) : ViewModel() {
    val foodList: LiveData<FoodListsResponse> = data.getFood

    fun getFoodList(token: String, id: String) {
        viewModelScope.launch {
            data.getListFood(token, id)
            Log.d("cekFood", "$foodList")
        }
    }
}