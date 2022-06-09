package com.example.capstone.response

import com.google.gson.annotations.SerializedName

data class ListActivitiesResponse(

	@field:SerializedName("data")
	val data: ListActivitiesData,

	@field:SerializedName("status")
	val status: String
)

data class ListActivitiesItem(

	@field:SerializedName("activityName")
	val activityName: String,

	@field:SerializedName("_id")
	val id: String
)

data class ListActivitiesData(

	@field:SerializedName("Activities")
	val activities: ArrayList<ListActivitiesItem>
)
