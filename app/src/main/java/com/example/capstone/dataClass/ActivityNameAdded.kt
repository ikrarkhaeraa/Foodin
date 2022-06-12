package com.example.capstone.dataClass

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ActivityNameAdded(

    @field:SerializedName("activities")
    val activities: ArrayList<ActivityNameAddedItem>

) : Parcelable

@Parcelize
data class ActivityNameAddedItem(

    @field:SerializedName("activityName")
    val activityName: String,

    @field:SerializedName("duration")
    val duration: Int,

) : Parcelable