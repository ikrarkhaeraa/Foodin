package com.example.capstone

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.capstone.model.DataSource

private val Context.database: DataStore<Preferences> by preferencesDataStore("token")

object Injection {
    fun provideRepository(context: Context): DataSource {
        val preferences = UserPreferences.getInstance(context.database)
        return DataSource.getInstance(preferences)
    }
}