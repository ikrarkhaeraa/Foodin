package com.example.capstone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.ModelFactory
import com.example.capstone.R
import com.example.capstone.adapter.ListResultAdapter
import com.example.capstone.dataClass.ListResult
import com.example.capstone.databinding.ActivityMainBinding
import com.example.capstone.databinding.ActivityResultBinding
import com.example.capstone.model.CalorieModel
import com.example.capstone.model.FoodListModel
import com.example.capstone.response.ListActivitiesItem

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private lateinit var factory: ModelFactory
    private val modelCalorie: CalorieModel by viewModels { factory }
    private val modelFood: FoodListModel by viewModels { factory }
    private var token = ""
    private var idUser = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        factory = ModelFactory.getInstance(this)
        chooseResult()
    }

    private fun chooseResult() {
        modelCalorie.getUserSession().observe(this@ResultActivity) {
            idUser = it.id
            token = it.token
            modelFood.getFoodList(token,idUser)

            Log.d("cekDataInResult", "$token")
            Log.d("cekDataInResult", "$idUser")
            Log.d("cekFood", "${modelFood.getFoodList(token, idUser)}")
        }

        modelFood.foodList.observe(this@ResultActivity) {
            val listFood1 = modelFood.foodList.value?.data?.foodLists?.get(0)
            val listFood2 = modelFood.foodList.value?.data?.foodLists?.get(1)
            val listFood3 = modelFood.foodList.value?.data?.foodLists?.get(2)
            Log.d("cekListFood", "$listFood1")
            Log.d("cekListFood", "$listFood2")
            Log.d("cekListFood", "$listFood3")
            Log.d("cekVegetable", "${listFood1?.brunch?.food}")

            binding.apply {
                val setName1 = binding.result1Number.text.toString()
                val setName2 = binding.result2Number.text.toString()
                val setName3 = binding.result3Number.text.toString()
                Log.d("cekSetName", "$setName1")
                Log.d("cekSetName", "$setName2")
                Log.d("cekSetName", "$setName3")
                set1Button.setOnClickListener {
                    val intentToNextPage = Intent(this@ResultActivity, DetailActivity::class.java)
                    intentToNextPage.putExtra(DetailActivity.SETNAME, setName1)
                    intentToNextPage.putExtra(DetailActivity.SETFOOD, listFood1)
                    startActivity(intentToNextPage)
                }
                set2Button.setOnClickListener {
                    val intentToNextPage = Intent(this@ResultActivity, DetailActivity::class.java)
                    intentToNextPage.putExtra(DetailActivity.SETNAME, setName2)
                    intentToNextPage.putExtra(DetailActivity.SETFOOD, listFood2)
                    startActivity(intentToNextPage)
                }
                set3Button.setOnClickListener {
                    val intentToNextPage = Intent(this@ResultActivity, DetailActivity::class.java)
                    intentToNextPage.putExtra(DetailActivity.SETNAME, setName3)
                    intentToNextPage.putExtra(DetailActivity.SETFOOD, listFood3)
                    startActivity(intentToNextPage)
                }
            }
        }

    }

}