package com.example.capstone.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.ModelFactory
import com.example.capstone.R
import com.example.capstone.data.entity.ActivityEntity
import com.example.capstone.data.room.Dao
import com.example.capstone.databinding.ItemActivityListBinding
import com.example.capstone.model.CalorieModel
import com.example.capstone.model.ListActivitiesModel
import com.example.capstone.response.ListActivitiesItem

class ActivityListAdapter (private val activityList: List<ListActivitiesItem>, private val activityDao: Dao)
    : RecyclerView.Adapter<ActivityListAdapter.ListViewHolder>() {

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

        val buttonBookmark = holder.binding.addButton
        if (activityDao.isBookmarked(activityList[position].id)) {
            buttonBookmark.visibility = View.INVISIBLE
        } else {
            buttonBookmark.visibility = View.VISIBLE
            buttonBookmark.setOnClickListener {
                activityDao.addActivity(activityList[position].id, activityList[position].activityName)
                buttonBookmark.visibility = View.INVISIBLE
                Log.d("cekAddButton", "${activityList[position].id}")
                Log.d("cekAddButton", "${activityList[position].activityName}")
            }
        }
    }

    override fun getItemCount(): Int = activityList.size
}