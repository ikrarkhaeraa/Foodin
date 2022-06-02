package com.example.capstone

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.capstone.model.UserSession
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class UserPreferences private constructor (private val database: DataStore<Preferences>) {

    companion object {
        @Volatile
        private var INSTANCE: UserPreferences? = null
        private val EMAIL_KEY = stringPreferencesKey("email")
        private val TOKEN_KEY = stringPreferencesKey("token")
        private val STATE_KEY = booleanPreferencesKey("state")

        fun getInstance(database: DataStore<Preferences>): UserPreferences {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreferences(database)
                INSTANCE = instance
                instance
            }
        }
    }

    fun getUserSession(): Flow<UserSession> {
        return database.data.map { preferences ->
            UserSession(
                preferences[EMAIL_KEY] ?: "",
                preferences[TOKEN_KEY] ?: "",
                preferences[STATE_KEY] ?: false
            )
        }
    }

    suspend fun saveUserSession(session: UserSession) {
        database.edit { preferences ->
            preferences[EMAIL_KEY] = session.email
            preferences[TOKEN_KEY] = session.token
            preferences[STATE_KEY] = session.isLogin
        }
    }

    suspend fun login() {
        database.edit { preferences ->
            preferences[STATE_KEY] = true
        }
    }

    suspend fun logout() {
        database.edit { preferences ->
            preferences.clear()
        }
    }
}