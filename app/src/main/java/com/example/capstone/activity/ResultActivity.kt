package com.example.capstone.activity

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

    private lateinit var rvResult: RecyclerView
    private lateinit var binding: ActivityResultBinding
    private val list = ArrayList<ListResult>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        binding = ActivityResultBinding.inflate(layoutInflater)

        rvResult = binding.rvResult
        rvResult.setHasFixedSize(true)

        list.addAll(listResults)
        showRecyclerList()
        Log.d("list", "$list")
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
        rvResult.layoutManager = LinearLayoutManager(this)
        val adapter = ListResultAdapter(list)
        rvResult.adapter = adapter
    }

}