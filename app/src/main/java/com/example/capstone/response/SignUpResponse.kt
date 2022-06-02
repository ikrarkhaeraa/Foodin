package com.example.capstone.response

import com.google.gson.annotations.SerializedName

data class SignUpResponse(

	@field:SerializedName("data")
	val data: DataSignUp,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class DataSignUp(

	@field:SerializedName("saveUser")
	val saveUser: SaveUser
)

data class SaveUser(

	@field:SerializedName("weightCurrent")
	val weightCurrent: String,

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("password")
	val password: String,

	@field:SerializedName("gender")
	val gender: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("age")
	val age: String,

	@field:SerializedName("height")
	val height: String,

	@field:SerializedName("goals")
	val goals: String
)
