package com.arclightcreatives.recyclerview_basicapparchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arclightcreatives.recyclerview_basicapparchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var mainviemodel: Mainviemodel
    private val repositoryRecyclerViewAdapter =RecyclerAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainviemodel = ViewModelProvider(this).get(Mainviemodel::class.java)
        activityMainBinding.viewmodel =mainviemodel
        activityMainBinding.executePendingBindings()

        activityMainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        activityMainBinding.recyclerView.adapter=repositoryRecyclerViewAdapter

        mainviemodel.dataViewmodel.observe(this,
            Observer<ArrayList<RepoModel>> {
                it?.let{ repositoryRecyclerViewAdapter.replace(it)} })


    }
}