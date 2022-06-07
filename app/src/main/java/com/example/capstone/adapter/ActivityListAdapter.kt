package com.example.capstone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.R
import com.example.capstone.data.entity.ActivityEntity
import com.example.capstone.databinding.ItemActivityListBinding
import com.example.capstone.response.ListActivitiesItem

class ActivityListAdapter (private val activityList: List<ListActivitiesItem>) : RecyclerView.Adapter<ActivityListAdapter.ListViewHolder>() {

    inner class ListViewHolder(var binding: ItemActivityListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data:ListActivitiesItem){
            binding.apply{
                binding.activityName.text = data.activityName
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemActivityListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(activityList[position])
    }

    override fun getItemCount(): Int = activityList.size


}