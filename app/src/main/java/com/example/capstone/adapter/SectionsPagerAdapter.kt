package com.example.capstone.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.capstone.data.room.Dao
import com.example.capstone.fragment.AddedActivityFragment
import com.example.capstone.fragment.ListActivityFragment
import com.example.capstone.model.DataSource

class SectionsPagerAdapter(activity: AppCompatActivity, private val data: DataSource, private val activityDao: Dao) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = ListActivityFragment(activityDao)
            1 -> fragment = AddedActivityFragment(data, activityDao)
        }
        return fragment as Fragment
    }

}