package com.example.capstone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.databinding.FragmentAddedActivityBinding

class AddedActivityFragment : Fragment() {
    private lateinit var binding: FragmentAddedActivityBinding
    private lateinit var adapter: RecyclerView
    private val addedActivity = ArrayList<ActivityNameAdded>()

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
        addedActivity.addAll(listActivities)
        showRecyclerList()
    }

    private val listActivities: ArrayList<ActivityNameAdded>
        get() {
            val dataName = resources.getStringArray(R.array.activity_name)
            val activity = ArrayList<ActivityNameAdded>()
            for (i in dataName.indices) {
                val list = ActivityNameAdded(dataName[i])
                activity.add(list)
            }
            return activity
        }

    private fun showRecyclerList() {
        adapter.layoutManager = LinearLayoutManager(context)
        val addedActivityAdapter = ActivityAddedAdapter(addedActivity)
        adapter.adapter = addedActivityAdapter
    }
}