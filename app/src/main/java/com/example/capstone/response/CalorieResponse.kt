package com.example.capstone.response

import com.google.gson.annotations.SerializedName

data class CalorieResponse(

	@field:SerializedName("data")
	val data: DataCalorie,

	@field:SerializedName("status")
	val status: String
)

data class DataCalorie(

	@field:SerializedName("totalCalories")
	val totalCalories: Int
)
