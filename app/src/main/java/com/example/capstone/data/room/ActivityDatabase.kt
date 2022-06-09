package com.example.capstone.data.room

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.capstone.data.entity.ActivityEntity

@Database(entities = [ActivityEntity::class],
    version = 2,
    exportSchema = false,)
abstract class ActivityDatabase : RoomDatabase() {
    abstract fun activityDao(): Dao

    companion object {
        @Volatile
        private var instance: ActivityDatabase? = null
        fun getInstance(context: Context): ActivityDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    ActivityDatabase::class.java, "ActivityAdded.db"
                ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
            }
    }
}