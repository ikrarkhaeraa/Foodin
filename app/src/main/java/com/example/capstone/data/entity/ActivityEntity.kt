package com.example.capstone.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activityList")
class ActivityEntity(
    @field:ColumnInfo(name = "activityName")
    @field:PrimaryKey
    val activityName: String,

//    @field:ColumnInfo(name = "duration")
//    val duration: Int,
//
//    @field:ColumnInfo(name = "bookmarked")
//    var isBookmarked: Boolean
)