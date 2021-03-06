package com.example.capstone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.example.capstone.ModelFactory
import com.example.capstone.R
import com.example.capstone.adapter.SectionsPagerAdapter
import com.example.capstone.databinding.ActivityMainBinding
import com.example.capstone.model.CalorieModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var factory: ModelFactory
    private val model: CalorieModel by viewModels { factory }
    private var token = ""
    private var idUser = ""

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_list_activity,
            R.string.tab_added_activity
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        factory = ModelFactory.getInstance(this)

        isLogin()
        //showCalorie()

        val sectionsPagerAdapter = SectionsPagerAdapter(this, model.getDataSource(), model.getDao())
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
        supportActionBar?.elevation = 0f
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.setting, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.setting -> {
                val i = Intent(this, SettingActivity::class.java)
                startActivity(i)
                true
            }
            R.id.logout -> {
                model.userLogout()
                finish()
                true
            }
            else -> true
        }
    }

    private fun isLogin() {
        model.getUserSession().observe(this@MainActivity) {
            token = it.token
            idUser = it.id
            if (!it.isLogin) {
                val intent = Intent(this@MainActivity, WelcomeActivity::class.java)
                startActivity(intent)
            } else {
                model.getCalorie(token, idUser)
                getUserCalorie()
            }
        }
    }

    private fun getUserCalorie() {
        model.calorie.observe(this@MainActivity) {
            binding.calorie.text = model.calorie.value?.data?.totalCalories.toString()
            model.checkCalorie()
        }
    }

}