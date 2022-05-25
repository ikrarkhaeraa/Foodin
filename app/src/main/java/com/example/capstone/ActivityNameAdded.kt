package com.example.capstone

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ActivityNameAdded(
    var activityNameAdded: String,
) : Parcelable