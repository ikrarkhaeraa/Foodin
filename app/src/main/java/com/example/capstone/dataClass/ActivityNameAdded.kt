package com.example.capstone.dataClass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ActivityNameAdded(
    var activityNameAdded: String,
) : Parcelable