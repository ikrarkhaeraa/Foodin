package com.example.capstone.response

import com.google.gson.annotations.SerializedName

data class FoodListResponse(

	@field:SerializedName("foodLists")
	val foodLists: List<FoodListsItem>
)

data class Lunch(

	@field:SerializedName("fruit")
	val fruit: String,

	@field:SerializedName("vegetable")
	val vegetable: String,

	@field:SerializedName("food")
	val food: String
)

data class Dinner(

	@field:SerializedName("fruit")
	val fruit: String,

	@field:SerializedName("vegetable")
	val vegetable: String,

	@field:SerializedName("food")
	val food: String
)

data class Breakfast(

	@field:SerializedName("fruit")
	val fruit: String,

	@field:SerializedName("vegetable")
	val vegetable: String,

	@field:SerializedName("food")
	val food: String
)

data class FoodListsItem(

	@field:SerializedName("dinner")
	val dinner: Dinner,

	@field:SerializedName("lunch")
	val lunch: Lunch,

	@field:SerializedName("breakfast")
	val breakfast: Breakfast
)
