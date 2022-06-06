package com.example.capstone.model

data class UserSession(
    val id: String,
    val token: String,
    val isLogin: Boolean
)