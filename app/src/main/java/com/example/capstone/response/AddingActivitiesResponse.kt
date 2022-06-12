package com.example.capstone.response

import com.google.gson.annotations.SerializedName

data class AddingActivitiesResponse(

	@field:SerializedName("duration")
	val duration: String,

	@field:SerializedName("activityName")
	val activityName: String
)
