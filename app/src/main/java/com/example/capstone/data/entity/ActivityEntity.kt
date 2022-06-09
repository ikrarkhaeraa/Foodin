package com.example.capstone.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activityList")
class ActivityEntity(
    @field:ColumnInfo(name = "id")
    @field:PrimaryKey
    var id: String = "",

    @field:ColumnInfo(name = "activityName")
    var activityName: String = "",

//    @field:ColumnInfo(name = "duration")
//    val duration: Int,
//
//    @field:ColumnInfo(name = "bookmarked")
//    var isBookmarked: Boolean
)