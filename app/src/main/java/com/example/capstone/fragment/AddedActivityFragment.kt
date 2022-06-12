package com.example.capstone.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.ModelFactory
import com.example.capstone.activity.ResultActivity
import com.example.capstone.activity.SignInActivity
import com.example.capstone.adapter.ActivityAddedAdapter
import com.example.capstone.dataClass.ActivityNameAddedItem
import com.example.capstone.databinding.FragmentAddedActivityBinding
import com.example.capstone.model.AddingActivitiesModel
import com.example.capstone.model.CalorieModel
import com.example.capstone.model.DataSource


class AddedActivityFragment (private val data: DataSource) : Fragment() {
    private lateinit var binding: FragmentAddedActivityBinding
    private lateinit var adapter: RecyclerView
    private lateinit var addedAdapter: ActivityAddedAdapter
    private lateinit var factory: ModelFactory
    private val model: AddingActivitiesModel by viewModels { factory }
    private val modelCalorie: CalorieModel by viewModels { factory }
    private var token = ""
    private var idUser = ""

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
        addedAdapter = ActivityAddedAdapter(data)
        adapter = binding.rvActivityAdded
        adapter.setHasFixedSize(true)
        showRecyclerList()
        postAdding()
    }

    private fun showRecyclerList() {
        adapter.layoutManager = LinearLayoutManager(context)
        adapter.adapter = addedAdapter
        data.getActivity()
    }

    private fun toResult() {
    }

    override fun onResume() {
        super.onResume()
        adapter.layoutManager = LinearLayoutManager(context)
        addedAdapter = ActivityAddedAdapter(data)
        adapter.adapter = addedAdapter
    }

    private fun postAdding() {
        binding.buttonAdded.setOnClickListener {
            val data = model.getActivity()
            val duration = addedAdapter.getDuration()
            val item: ArrayList<ActivityNameAddedItem> = ArrayList(duration.size)
            modelCalorie.getUserSession().observe(this.requireActivity()) {
                token = it.token
                idUser = it.id
                for (i in duration.indices) {
                    item.apply {
                        add(ActivityNameAddedItem(data?.get(i)!!.activityName, duration[i]))
                        val activityName = data[i].activityName
                        val activityDuration = duration[i]
                        model.postDataAdding(token, idUser, activityName, activityDuration)
                        Log.d("cekMap", "$activityName")
                        Log.d("cekMap", "$activityDuration")
                    }
                }
            }
//            toResult()
            model.addingActivitiesModel.observe(this.requireActivity()) {
                if (it.status == "success") {
                    val intent = Intent(this.context, ResultActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this.context,"Upload Activity Invalid", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}