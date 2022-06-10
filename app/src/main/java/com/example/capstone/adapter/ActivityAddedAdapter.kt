package com.example.capstone.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.data.entity.ActivityEntity
import com.example.capstone.data.room.Dao
import com.example.capstone.databinding.ItemActivityAddedBinding
import com.example.capstone.model.DataSource

class ActivityAddedAdapter (private val data: DataSource) : RecyclerView.Adapter<ActivityAddedAdapter.ListViewHolder>() {

    private var activityList : List<ActivityEntity>? = data.getActivity()
    private var duration: ArrayList<Int> = arrayListOf(activityList?.size?: 0)

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

        val buttonBookmark = holder.binding.minButton
        buttonBookmark.setOnClickListener {
            buttonBookmark.visibility = View.INVISIBLE
            data.deleteActivity(activityList!!.get(position).id)
            Log.d("cekMinButton", "${activityList!!.get(position).id}")
        }

        val tbHours = holder.binding.tbHours.text.toString()
        val intHours = tbHours.toInt()
        val tbMinutes = holder.binding.tbMinutes.text.toString()
        val intMinutes = tbMinutes.toInt()
        duration[position] = (intHours*60) + intMinutes
    }

    override fun getItemCount(): Int = activityList?.size?: 0

    fun getDuration() {
        Log.d("cekDuration", "$duration")
    }
}
