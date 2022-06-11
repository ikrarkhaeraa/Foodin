package com.example.capstone.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.data.entity.ActivityEntity
import com.example.capstone.data.room.Dao
import com.example.capstone.databinding.ItemActivityAddedBinding
import com.example.capstone.model.DataSource

class ActivityAddedAdapter (private val data: DataSource) : RecyclerView.Adapter<ActivityAddedAdapter.ListViewHolder>() {

    private var activityList : List<ActivityEntity>? = data.getActivity()
    private var duration = IntArray(itemCount)

    inner class ListViewHolder(var binding: ItemActivityAddedBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ActivityEntity){
            binding.apply{
                binding.activityAdded.text = data.activityName
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemActivityAddedBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(activityList!!.get(position))

        var intHours = 0
        var intMinutes = 0
        duration[position] = (intHours*60) + intMinutes

        if (holder.binding.tbHours.text.toString() == "") {
        } else {
            intHours = holder.binding.tbHours.text.toString().toInt()
        }
        holder.binding.tbHours.addTextChangedListener {
            if(it.toString() == "") {
                intHours = 0
                duration[position] = (intHours*60) + intMinutes
            } else {
                intHours = it.toString().toInt()
                duration[position] = (intHours*60) + intMinutes
            }
        }

        if (holder.binding.tbMinutes.text.toString() == "") {
        } else {
            intMinutes = holder.binding.tbMinutes.text.toString().toInt()
        }
        holder.binding.tbMinutes.addTextChangedListener {
            if (it.toString() == "") {
                intMinutes = 0
                duration[position] = (intHours*60) + intMinutes
            } else {
                intMinutes = it.toString().toInt()
                duration[position] = (intHours*60) + intMinutes
            }
        }

        val buttonBookmark = holder.binding.minButton
        buttonBookmark.setOnClickListener {
            buttonBookmark.visibility = View.INVISIBLE
            data.deleteActivity(activityList!!.get(position).id)
        }

    }

    override fun getItemCount(): Int = activityList?.size?: 0

    fun getDuration() : List<Int> {
        return duration.toList()
    }

}
