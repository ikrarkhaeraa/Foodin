package com.example.capstone.api

import com.example.capstone.dataClass.ActivityNameAdded
import com.example.capstone.dataClass.ActivityNameAddedItem
import com.example.capstone.response.*
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("regis")
    fun uploadDataSignUp(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("name") name: String,
        @Field("weightCurrent") weightCurrent: Int,
        @Field("height") height: Int,
        @Field("gender") gender: String,
        @Field("age") age: Int,
        @Field("goals") goals: String
    ): Call<SignUpResponse>

    @FormUrlEncoded
    @POST("login")
    fun uploadDataSignIn(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Call<SignInResponse>

    @GET("home/{id}")
    fun getCalorie(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Call<CalorieResponse>

    @GET("activities")
    fun getListActivities(
    ): Call<ListActivitiesResponse>

    @FormUrlEncoded
    @POST("home/activities/{id}")
    fun addingActivities(
        @Header("Authorization") token: String,
        @Path("id") id: String,
        //@FieldMap activities: HashMap<String, String>,
        @Field ("activityName") activityName: String,
        @Field("duration") duration: Int,

    ):Call<AddingActivitiesResponse>

    @GET("foods/{id}")
    fun getFood(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Call<FoodListResponse>
}