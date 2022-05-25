package com.example.capstone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.R
import com.example.capstone.dataClass.ListResult

class ListResultAdapter (private val listResult: ArrayList<ListResult>) : RecyclerView.Adapter<ListResultAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.result_number)
        var imgPhoto: ImageView = itemView.findViewById(R.id.photo_result)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_result, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, photo) = listResult[position]
        holder.tvName.text = name
        holder.imgPhoto.setImageResource(photo)
    }

    override fun getItemCount(): Int = listResult.size

}