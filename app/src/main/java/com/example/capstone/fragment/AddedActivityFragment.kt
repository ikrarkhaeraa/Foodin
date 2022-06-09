package com.example.capstone.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.activity.ResultActivity
import com.example.capstone.adapter.ActivityAddedAdapter
import com.example.capstone.databinding.FragmentAddedActivityBinding
import com.example.capstone.model.DataSource

class AddedActivityFragment (private val data: DataSource) : Fragment() {
    private lateinit var binding: FragmentAddedActivityBinding
    private lateinit var adapter: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddedActivityBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = binding.rvActivityAdded
        adapter.setHasFixedSize(true)
        showRecyclerList()
        toResult()
    }

//    private val listActivities: ArrayList<ActivityNameAdded>
//        get() {
//            val dataName = resources.getStringArray(R.array.activity_added_list)
//            val activity = ArrayList<ActivityNameAdded>()
//            for (i in dataName.indices) {
//                val list = ActivityNameAdded(dataName[i])
//                activity.add(list)
//            }
//            return activity
//        }

    private fun showRecyclerList() {
        adapter.layoutManager = LinearLayoutManager(context)
        val addedActivityAdapter = ActivityAddedAdapter(data)
        adapter.adapter = addedActivityAdapter
    }

    private fun toResult() {
        binding.buttonAdded.setOnClickListener {
            val intentToResult = Intent(this.context, ResultActivity::class.java)
            startActivity(intentToResult)
        }
    }
}