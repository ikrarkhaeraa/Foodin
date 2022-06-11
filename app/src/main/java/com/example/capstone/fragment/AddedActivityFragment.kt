package com.example.capstone.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import com.example.capstone.dataClass.ActivityNameAdded
import com.example.capstone.dataClass.ActivityNameAddedItem
import com.example.capstone.databinding.FragmentAddedActivityBinding
import com.example.capstone.model.AddingActivitiesModel
import com.example.capstone.model.CalorieModel
import com.example.capstone.model.DataSource
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.util.EnumSet.range

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
            val intentToResult = Intent(this.context, ResultActivity::class.java)
            startActivity(intentToResult)

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
            for (i in duration.indices) {
                item.apply {
                    add(ActivityNameAddedItem(data?.get(i)!!.activityName, duration[i]))
                }
            }
            val dataItem = ActivityNameAdded(item)
            Log.d("cekDataItem", "$dataItem")
            Log.d("cekLoop", "$item")
            modelCalorie.getUserSession().observe(this.requireActivity()) {
                token = it.token
                idUser = it.id
                model.postDataAdding(token, idUser, data?.get(0)!!.activityName, duration[0].toString().toInt())
            }
        }
    }

}