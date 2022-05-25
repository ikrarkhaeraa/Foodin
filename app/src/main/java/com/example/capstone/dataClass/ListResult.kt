package com.example.capstone.dataClass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListResult(
    var setNumber: String,
    var photo: Int
) : Parcelable