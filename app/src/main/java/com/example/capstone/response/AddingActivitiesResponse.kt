package com.example.capstone.response

import com.google.gson.annotations.SerializedName

data class AddingActivitiesResponse(

	@field:SerializedName("activities")
	val activities: List<AddingActivitiesItem>
)

data class AddingActivitiesItem(

	@field:SerializedName("duration")
	val duration: String,

	@field:SerializedName("activityName")
	val activityName: String
)
