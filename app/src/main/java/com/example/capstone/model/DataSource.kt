package com.example.capstone.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.example.capstone.AppExecutors
import com.example.capstone.UserPreferences
import com.example.capstone.api.ApiConfig
import com.example.capstone.data.entity.ActivityEntity
import com.example.capstone.data.room.Dao
import com.example.capstone.dataClass.ActivityNameAdded
import com.example.capstone.dataClass.ActivityNameAddedItem
import com.example.capstone.response.SignInResponse
import com.example.capstone.response.*
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.Duration

class DataSource private constructor(
    private val pref: UserPreferences,
    private val activityDao: Dao,
    private val appExecutors: AppExecutors
) {

    companion object {
        @Volatile
        private var instance: DataSource? = null
        fun getInstance(
            preferences: UserPreferences,
            activityDao: Dao,
            appExecutors: AppExecutors
        ): DataSource =
            instance ?: synchronized(this) {
                instance ?: DataSource(preferences, activityDao, appExecutors)
            }.also { instance = it }
    }

    //private val result = MediatorLiveData<Result<List<ActivityEntity>>>()

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
    val getFood: LiveData<FoodListResponse>? = _getFood

    fun uploadSignUpData(email:String, password:String, name: String, weightCurrent: Int, height:Int, gender:String,
                         age:Int, goals:String) {
        val client = ApiConfig.getApiService()
            .uploadDataSignUp(email, password, name, weightCurrent, height,
            gender, age, goals)
        client.enqueue(object : Callback<SignUpResponse> {
            override fun onResponse(
                call: Call<SignUpResponse>,
                response: Response<SignUpResponse>
            ) {
                if (response.isSuccessful) {
                    Log.e("signUpResponse", "onResponse: ${response.message()}")
                    _signUp.value = response.body()
                } else {
                    Log.e("signUp", "onResponse: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                Log.e("signUpFailure", "onFailure: ${t.message}")
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
                if (response.isSuccessful) {
                    Log.e("signInResponse", "onResponse: ${response.message()}")
                    _signIn.value = response.body()
                } else {
                    Log.e("signIn", "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                Log.e("loginFailure", "onFailure: ${t.message}")
            }
        })
    }

    fun getCalorie(token: String, id: String) {
        val client = ApiConfig.getApiService().getCalorie(token, id)
        client.enqueue(object : Callback<CalorieResponse> {
            override fun onResponse(
                call: Call<CalorieResponse>,
                response: Response<CalorieResponse>
            ) {
                if (response.isSuccessful) {
                    Log.e("calorieResponse", "onResponse: ${response.body()}")
                    _getCalorie.value = response.body()
                } else {
                    Log.e("calorie", "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<CalorieResponse>, t: Throwable) {
                Log.e("calorieFailure", "onFailure: ${t.message}")
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
                if (response.isSuccessful) {
                    Log.e("listActivityResponse", "onResponse: ${response.message()}")
                    _listActivities.value = response.body()
                } else {
                    Log.e("listActivity", "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<ListActivitiesResponse>, t: Throwable) {
                Log.e("storyFailure", "onFailure: ${t.message}")
            }
        })
    }

    fun addingActivities (token: String, id: String, activityName: String, duration: Int) {
        val client = ApiConfig.getApiService().addingActivities(token, id, activityName, duration)
        client.enqueue(object : Callback<AddingActivitiesResponse> {
            override fun onResponse(
                call: Call<AddingActivitiesResponse>,
                response: Response<AddingActivitiesResponse>
            ) {
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

    fun getListFood (token: String, id: String) {
        val client = ApiConfig.getApiService().getFood(token, id)
        client.enqueue(object : Callback<FoodListResponse> {
            override fun onResponse(
                call: Call<FoodListResponse>,
                response: Response<FoodListResponse>
            ) {
                if (response.isSuccessful) {
                    Log.e("cekFood", "onResponse: ${response.message()}")
                    _getFood?.value = response.body()
                } else {
                    Log.e("cekFood", "onFailure: ${response.message()}")
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


    fun addActivity(id: String, activityName: String) {
        appExecutors.diskIO.execute{
            activityDao.addActivity(id, activityName)
        }
    }

    fun deleteActivity(id: String) {
        appExecutors.diskIO.execute{
            activityDao.deleteActivity(id)
        }
    }

    fun isBookmarked(id: String) {
        appExecutors.diskIO.execute {
            activityDao.isBookmarked(id)
        }
    }

    fun getActivity() : List<ActivityEntity>? {
        return activityDao.getActivity()
    }

    fun getDao() : Dao {
        return activityDao
    }

}