package com.example.capstone.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.capstone.R
import com.example.capstone.databinding.ActivityDetailBinding
import com.example.capstone.databinding.ActivityResultBinding
import com.example.capstone.response.Data
import com.example.capstone.response.FoodListsItem

class DetailActivity : AppCompatActivity() {

    companion object {
        const val SETFOOD = "food"
        const val SETNAME = "name"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val setName = intent.getStringExtra(SETNAME).toString()
        val setFood = intent.getParcelableExtra<FoodListsItem>(SETFOOD)
        binding.apply {
            binding.setDetail.text = setName

            foodBreakfast.text = setFood?.breakfast?.food
            vegetableBreakfast.text = setFood?.breakfast?.vegetable
            fruitBreakfast.text = setFood?.breakfast?.fruit

            foodBrunch.text = setFood?.brunch?.food
            vegetableBrunch.text = setFood?.brunch?.vegetable
            fruitBrunch.text = setFood?.brunch?.fruit

            foodLunch.text = setFood?.lunch?.food
            vegetableLunch.text = setFood?.lunch?.vegetable
            fruitLunch.text = setFood?.lunch?.fruit

            foodDinner.text = setFood?.dinner?.food
            vegetableDinner.text = setFood?.dinner?.vegetable
            fruitDinner.text = setFood?.dinner?.fruit
        }
        setContentView(binding.root)
    }

    private fun breakfast() {
        binding.apply {

        }
    }

    private fun brunch() {
        binding.apply {

        }
    }

    private fun lunch() {
        binding.apply {
        }
    }

    private fun dinner() {
        binding.apply {
        }
    }
}