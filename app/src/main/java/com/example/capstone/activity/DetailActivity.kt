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
    val setName = intent.getStringExtra(SETNAME)
    val setFood = intent.getParcelableExtra<FoodListsItem>(SETFOOD)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setName()
        breakfast()
        brunch()
        lunch()
        dinner()
        Log.d("cekSetFood", "$setFood")
        setContentView(binding.root)
    }

    private fun setName() {
        binding.setDetail.text = setName
    }

    private fun breakfast() {
        binding.apply {
            foodBreakfast.text = setFood?.breakfast?.food
            vegetableBreakfast.text = setFood?.breakfast?.vegetable
            fruitBreakfast.text = setFood?.breakfast?.fruit
        }
    }

    private fun brunch() {
        binding.apply {
            foodBreakfast.text = setFood?.brunch?.food
            vegetableBreakfast.text = setFood?.brunch?.vegetable
            fruitBreakfast.text = setFood?.brunch?.fruit
        }
    }

    private fun lunch() {
        binding.apply {
            foodBreakfast.text = setFood?.lunch?.food
            vegetableBreakfast.text = setFood?.lunch?.vegetable
            fruitBreakfast.text = setFood?.lunch?.fruit
        }
    }

    private fun dinner() {
        binding.apply {
            foodBreakfast.text = setFood?.dinner?.food
            vegetableBreakfast.text = setFood?.dinner?.vegetable
            fruitBreakfast.text = setFood?.dinner?.fruit
        }
    }
}