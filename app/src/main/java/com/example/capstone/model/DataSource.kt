package com.example.capstone.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.example.capstone.UserPreferences
import com.example.capstone.api.ApiConfig
import com.example.capstone.api.SignInResponse
import com.example.capstone.response.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataSource private constructor(
    private val pref: UserPreferences,
) {

    companion object {
        @Volatile
        private var instance: DataSource? = null
        fun getInstance(
            preferences: UserPreferences,
        ): DataSource =
            instance ?: synchronized(this) {
                instance ?: DataSource(preferences)
            }.also { instance = it }
    }

    private val _signUp = MutableLiveData<SignUpResponse>()
    val signUp: LiveData<SignUpResponse> = _signUp

    private val _signIn = MutableLiveData<SignInResponse>()
    val signIn: LiveData<SignInResponse> = _signIn

    private val _add = MutableLiveData<AddingActivitiesResponse>()
    val add: LiveData<AddingActivitiesResponse> = _add

    private val _listActivities = MutableLiveData<ListActivitiesResponse>()
    val listActivities: LiveData<ListActivitiesResponse> = _listActivities

    private val _getCalorie = MutableLiveData<CalorieResponse>()
    val getCalorie: LiveData<CalorieResponse> = _getCalorie

    private val _getFood = MutableLiveData<FoodListResponse>()
    val getFood: LiveData<FoodListResponse> = _getFood

    fun uploadSignUpData(email:String, password:String, weightCurrent: Int, height:Int, gender:String,
                         age:Int, goals:String) {
        val client = ApiConfig.getApiService()
            .uploadDataSignUp(email, password, weightCurrent, height,
            gender, age, goals)
        client.enqueue(object : Callback<SignUpResponse> {
            override fun onResponse(
                call: Call<SignUpResponse>,
                response: Response<SignUpResponse>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful) {
                    Log.e("regisResponse", "onResponse: ${response.message()}")
                    _signUp.value = response.body()
                } else {
                    Log.e("regis", "onResponse: ${response.message()} / akun sudah ada")

                }
            }
            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                Log.e("regisFailure", "onFailure: ${t.message}")
            }
        })
    }

    fun uploadSignInData(email:String, password:String) {
        val client = ApiConfig.getApiService().uploadDataSignIn(email, password)
        client.enqueue(object : Callback<SignInResponse> {
            override fun onResponse(
                call: Call<SignInResponse>,
                response: Response<SignInResponse>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful) {
                    Log.e("loginResponse", "onResponse: ${response.message()}")
                    _signIn.value = response.body()
                } else {
                    Log.e("login", "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                Log.e("loginFailure", "onFailure: ${t.message}")
            }
        })
    }

    fun getCalorie(token: String) {
        val client = ApiConfig.getApiService().getCalorie(token)
        client.enqueue(object : Callback<CalorieResponse> {
            override fun onResponse(
                call: Call<CalorieResponse>,
                response: Response<CalorieResponse>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful) {
                    Log.e("storyResponse", "onResponse: ${response.message()}")
                    _getCalorie.value = response.body()
                } else {
                    Log.e("story", "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<CalorieResponse>, t: Throwable) {
                Log.e("storyFailure", "onFailure: ${t.message}")
            }
        })
    }

    fun getListActivities() {
        val client = ApiConfig.getApiService().getListActivities()
        client.enqueue(object : Callback<ListActivitiesResponse> {
            override fun onResponse(
                call: Call<ListActivitiesResponse>,
                response: Response<ListActivitiesResponse>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful) {
                    Log.e("storyResponse", "onResponse: ${response.message()}")
                    _listActivities.value = response.body()
                } else {
                    Log.e("story", "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<ListActivitiesResponse>, t: Throwable) {
                Log.e("storyFailure", "onFailure: ${t.message}")
            }
        })
    }

    fun addingActivities (token: String, activityName: String, duration: Int) {
        val client = ApiConfig.getApiService().addingActivities(token, activityName, duration)
        client.enqueue(object : Callback<AddingActivitiesResponse> {
            override fun onResponse(
                call: Call<AddingActivitiesResponse>,
                response: Response<AddingActivitiesResponse>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful) {
                    Log.e("addResponse", "onResponse: ${response.message()}")
                    _add.value = response.body()
                } else {
                    Log.e("add", "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<AddingActivitiesResponse>, t: Throwable) {
                Log.e("addFailure", "onFailure: ${t.message}")
            }
        })
    }

    fun getListFood (token: String) {
        val client = ApiConfig.getApiService().getFood(token)
        client.enqueue(object : Callback<FoodListResponse> {
            override fun onResponse(
                call: Call<FoodListResponse>,
                response: Response<FoodListResponse>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful) {
                    Log.e("addResponse", "onResponse: ${response.message()}")
                    _getFood.value = response.body()
                } else {
                    Log.e("add", "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<FoodListResponse>, t: Throwable) {
                Log.e("addFailure", "onFailure: ${t.message}")
            }
        })
    }

    fun getUserSession(): LiveData<UserSession> {
        return pref.getUserSession().asLiveData()
    }

    suspend fun saveSession(session: UserSession) {
        pref.saveUserSession(session)
    }

    suspend fun userLogin() {
        pref.login()
    }

    suspend fun userLogout() {
        pref.logout()
    }

}