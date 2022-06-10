package com.example.capstone.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.core.view.get
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.ModelFactory
import com.example.capstone.activity.ResultActivity
import com.example.capstone.adapter.ActivityAddedAdapter
import com.example.capstone.data.room.Dao
import com.example.capstone.databinding.FragmentAddedActivityBinding
import com.example.capstone.model.AddingActivitiesModel
import com.example.capstone.model.CalorieModel
import com.example.capstone.model.DataSource

class AddedActivityFragment (private val data: DataSource) : Fragment() {
    private lateinit var binding: FragmentAddedActivityBinding
    private lateinit var adapter: RecyclerView
    private lateinit var factory: ModelFactory
    private val model: AddingActivitiesModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddedActivityBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = ModelFactory.getInstance(this.requireContext())
        adapter = binding.rvActivityAdded
        adapter.setHasFixedSize(true)
        showRecyclerList()
        convertDuration()
        postAdding()
        //toResult()
    }

    private fun showRecyclerList() {
        adapter.layoutManager = LinearLayoutManager(context)
        val addedActivityAdapter = ActivityAddedAdapter(data)
        adapter.adapter = addedActivityAdapter
        data.getActivity()
        binding.buttonAdded.setOnClickListener {
            addedActivityAdapter.getDuration()
        }
    }

    private fun toResult() {
        binding.buttonAdded.setOnClickListener {
            val intentToResult = Intent(this.context, ResultActivity::class.java)
            startActivity(intentToResult)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.layoutManager = LinearLayoutManager(context)
        val addedActivityAdapter = ActivityAddedAdapter(data)
        adapter.adapter = addedActivityAdapter
    }

    private fun postAdding() {
        binding.buttonAdded.setOnClickListener {
            val data = model.getActivity()
            //model.postDataAdding()
        }
    }

    private fun convertDuration() {
    }

}