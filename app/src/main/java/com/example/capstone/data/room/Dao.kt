package com.example.capstone.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.capstone.data.entity.ActivityEntity

@androidx.room.Dao
interface Dao {

//    @Query("SELECT * FROM activityList where bookmarked = 1")
//    fun getBookmarked(): LiveData<List<ActivityEntity>>
//
//    @Update
//    fun updateNews(added: ActivityEntity)
//
//    @Query("DELETE FROM activityList WHERE bookmarked = 0")
//    fun deleteAll()
//
    @Query("SELECT EXISTS(SELECT * FROM activityList WHERE id = :id)")
    fun isBookmarked(id: String): Boolean

    @Query("INSERT INTO activityList (id, activityName) values (:id, :activityName)")
    fun addActivity(id: String, activityName: String)

    @Query("DELETE FROM activityList WHERE id = :id")
    fun deleteActivity(id: String)

    @Query("SELECT * FROM activityList")
    fun getActivity() : List<ActivityEntity>?
}