package com.example.capstone.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.adapter.ActivityListAdapter
import com.example.capstone.dataClass.ActivityName
import com.example.capstone.R
import com.example.capstone.databinding.FragmentListActivityBinding

class ListActivityFragment : Fragment() {
    private lateinit var binding: FragmentListActivityBinding
    private lateinit var adapter: RecyclerView
    private val listActivity = ArrayList<ActivityName>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListActivityBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = binding.rvActivityList
        adapter.setHasFixedSize(true)
        listActivity.addAll(listActivities)
        showRecyclerList()
    }

    private val listActivities: ArrayList<ActivityName>
        get() {
            val dataName = resources.getStringArray(R.array.activity_name_list)
            val activity = ArrayList<ActivityName>()
            for (i in dataName.indices) {
                val list = ActivityName(dataName[i])
                activity.add(list)
            }
            return activity
        }

    private fun showRecyclerList() {
        adapter.layoutManager = LinearLayoutManager(this.context)
        val listActivityAdapter = ActivityListAdapter(listActivity)
        adapter.adapter = listActivityAdapter
    }

}