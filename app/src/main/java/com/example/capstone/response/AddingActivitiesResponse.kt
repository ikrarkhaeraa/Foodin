package com.example.capstone.response

import com.google.gson.annotations.SerializedName

data class AddingActivitiesResponse(

	@field:SerializedName("activities")
	val activities: List<ActivitiesItem>,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class ActivitiesItem(

	@field:SerializedName("duration")
	val duration: String,

	@field:SerializedName("activityName")
	val activityName: String
)
