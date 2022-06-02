package com.example.capstone

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.capstone.model.*
import com.example.capstone.response.ListActivitiesResponse

class ModelFactory(private val dataSource: DataSource) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ModelFactory? = null
        fun getInstance(context: Context): ModelFactory {
            return instance ?: synchronized(this) {
                instance ?: ModelFactory(Injection.provideRepository(context))
            }.also { instance = it }
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(SignInModel::class.java) -> {
                SignInModel(dataSource) as T
            }
            modelClass.isAssignableFrom(SignUpModel::class.java) -> {
                SignUpModel(dataSource) as T
            }
            modelClass.isAssignableFrom(CalorieModel::class.java) -> {
                CalorieModel(dataSource) as T
            }
            modelClass.isAssignableFrom(ListActivitiesModel::class.java) -> {
                ListActivitiesModel(dataSource) as T
            }
            modelClass.isAssignableFrom(AddingActivitiesModel::class.java) -> {
                AddingActivitiesModel(dataSource) as T
            }
            modelClass.isAssignableFrom(FoodListModel::class.java) -> {
                FoodListModel(dataSource) as T
            }
            else -> throw IllegalArgumentException("Unknown Model class: " + modelClass.name)
        }
    }
}