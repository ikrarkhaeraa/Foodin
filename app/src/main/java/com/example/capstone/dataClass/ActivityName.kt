package com.example.capstone.dataClass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ActivityName(
    var activityName: String,
) : Parcelable