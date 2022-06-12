package com.example.capstone.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FoodListsResponse(

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("status")
	val status: String
) : Parcelable

@Parcelize
data class Data(

	@field:SerializedName("foodLists")
	val foodLists: List<FoodListsItem>
) : Parcelable

@Parcelize
data class Breakfast(

	@field:SerializedName("fruit")
	val fruit: String,

	@field:SerializedName("vegetable")
	val vegetable: String,

	@field:SerializedName("food")
	val food: String
) : Parcelable

@Parcelize
data class FoodListsItem(

	@field:SerializedName("lunch")
	val lunch: Lunch,

	@field:SerializedName("brunch")
	val brunch: Brunch,

	@field:SerializedName("breakfast")
	val breakfast: Breakfast,

	@field:SerializedName("dinner")
	val dinner: Dinner
) : Parcelable

@Parcelize
data class Brunch(

	@field:SerializedName("fruit")
	val fruit: String,

	@field:SerializedName("vegetable")
	val vegetable: String,

	@field:SerializedName("food")
	val food: String
) : Parcelable

@Parcelize
data class Lunch(

	@field:SerializedName("fruit")
	val fruit: String,

	@field:SerializedName("vegetable")
	val vegetable: String,

	@field:SerializedName("food")
	val food: String
) : Parcelable

@Parcelize
data class Dinner(

	@field:SerializedName("fruit")
	val fruit: String,

	@field:SerializedName("vegetable")
	val vegetable: String,

	@field:SerializedName("food")
	val food: String
) : Parcelable
