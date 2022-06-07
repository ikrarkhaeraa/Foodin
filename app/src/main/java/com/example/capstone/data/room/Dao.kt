package com.example.capstone.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.capstone.data.entity.ActivityEntity

@androidx.room.Dao
interface Dao {

    @Query("SELECT * FROM activityList where bookmarked = 1")
    fun getBookmarked(): LiveData<List<ActivityEntity>>

    @Update
    fun updateNews(added: ActivityEntity)

    @Query("DELETE FROM activityList WHERE bookmarked = 0")
    fun deleteAll()

    @Query("SELECT EXISTS(SELECT * FROM activityList WHERE activityName = :activityName AND bookmarked = 1)")
    fun isBookmarked(activityName: String): Boolean
}