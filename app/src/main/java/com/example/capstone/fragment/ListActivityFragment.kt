package com.example.capstone.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.ModelFactory
import com.example.capstone.adapter.ActivityListAdapter
import com.example.capstone.data.room.Dao
import com.example.capstone.databinding.FragmentListActivityBinding
import com.example.capstone.model.ListActivitiesModel
import com.example.capstone.response.ListActivitiesItem

class ListActivityFragment (private val activityDao: Dao) : Fragment() {
    private lateinit var binding: FragmentListActivityBinding
    private lateinit var rvStory: RecyclerView
    private lateinit var listActivity: ArrayList<ListActivitiesItem>
    private lateinit var factory: ModelFactory
    private val model: ListActivitiesModel by viewModels { factory }

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
        rvStory = binding.rvActivityList
        rvStory.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this.context)
        binding.rvActivityList.layoutManager = layoutManager
        factory = ModelFactory.getInstance(this.requireContext())

        model.listActivities.observe(viewLifecycleOwner) {
            listActivity = it.data.activities as ArrayList<ListActivitiesItem>
            Log.d("story", listActivity.toString())
        }
        model.getListActivity()
        settingAdapter()
    }

    private fun settingAdapter() {
        model.listActivities.observe(viewLifecycleOwner) {
                adapter ->
            if (adapter != null) {
                binding.rvActivityList.adapter = ActivityListAdapter(adapter.data.activities, activityDao)
            }
        }
    }

}