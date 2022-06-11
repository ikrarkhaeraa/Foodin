package com.example.capstone.dataClass

import android.os.Parcelable
import com.example.capstone.response.AddingActivitiesItem
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ActivityNameAdded(

    @field:SerializedName("activities")
    val activities: List<ActivityNameAddedItem>

) : Parcelable

@Parcelize
data class ActivityNameAddedItem(

    @field:SerializedName("activityName")
    val activityName: String,

    @field:SerializedName("activityName")
    val duration: Int,

) : Parcelable