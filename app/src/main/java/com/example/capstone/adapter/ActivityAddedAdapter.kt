package com.example.capstone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.data.room.Dao
import com.example.capstone.databinding.ItemActivityAddedBinding
import com.example.capstone.model.DataSource

class ActivityAddedAdapter (private val data: DataSource) : RecyclerView.Adapter<ActivityAddedAdapter.ListViewHolder>() {

    private val getActivityDao : List<String>? = data.getActivity()

    inner class ListViewHolder(var binding: ItemActivityAddedBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String){
            binding.apply{
                binding.activityAdded.text = data
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemActivityAddedBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(getActivityDao?.get(position) ?: "null")

        val toggleBookmark = holder.binding.minButton
        toggleBookmark.setOnClickListener {
            data.deleteActivity(getActivityDao?.get(position) ?: "null")
        }
    }

    override fun getItemCount(): Int = getActivityDao?.size?: 0
}
