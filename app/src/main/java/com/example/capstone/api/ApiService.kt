package com.example.capstone.api

import com.example.capstone.response.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("regis")
    fun uploadDataSignUp(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("weightCurrent") weightCurrent: Int,
        @Field("height") height: Int,
        @Field("gender") gender: String,
        @Field("age") age: Int,
        @Field("goals") goals: String,
    ): Call<SignUpResponse>

    @FormUrlEncoded
    @POST("home/{id}")
    fun uploadDataSignIn(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Call<SignInResponse>

    @GET("stories")
    fun getCalorie(
        @Header("Authorization") token: String,
    ): Call<CalorieResponse>

    @GET("activities")
    fun getListActivities(
    ): Call<ListActivitiesResponse>

    @Multipart
    @POST("home/activities/{id_user}")
    fun addingActivities(
        @Header("Authorization") token: String,
        @Part("activityName") activityName: String,
        @Field("duration") duration: Int,
    ):Call<AddingActivitiesResponse>

    @GET("foods/{id}")
    fun getFood(
        @Header("Authorization") token: String,
    ): Call<FoodListResponse>

}