package com.example.capstone.response

import com.google.gson.annotations.SerializedName

data class SignInResponse(

	@field:SerializedName("data")
	val data: DataSignIn,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class DataSignIn(

	@field:SerializedName("token")
	val token: String
)
