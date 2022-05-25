package com.example.capstone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.R
import com.example.capstone.adapter.ListResultAdapter
import com.example.capstone.dataClass.ListResult
import com.example.capstone.databinding.ActivityMainBinding
import com.example.capstone.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerView
    private lateinit var binding: ActivityResultBinding
    private val list = ArrayList<ListResult>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = binding.rvResult
        adapter.setHasFixedSize(true)

        list.addAll(listResults)
        showRecyclerList()
    }

    private val listResults: ArrayList<ListResult>
        get() {
            val dataName = resources.getStringArray(R.array.result_list)
            val dataPhoto = resources.obtainTypedArray(R.array.result_photo_list)
            val listRes = ArrayList<ListResult>()
            for (i in dataName.indices) {
                val result = ListResult(dataName[i],dataPhoto.getResourceId(i, -1))
                listRes.add(result)
            }
            return listRes
        }
    private fun showRecyclerList() {
        adapter.layoutManager = LinearLayoutManager(this)
        val listResultAdapter = ListResultAdapter(list)
        adapter.adapter = listResultAdapter

        listResultAdapter.setOnItemClickCallback(object : ListResultAdapter.OnItemClickCallback{
            override fun onItemClicked(result: ListResult) {
                val intentToDetail = Intent(this@ResultActivity, DetailActivity::class.java)
                intentToDetail.putExtra("DATA", result)
                startActivity(intentToDetail)
            }
        })

    }

}