package com.upday.assignment.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.upday.assignment.databinding.MainActivityBinding
import com.upday.assignment.ui.adapter.ImagesListAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModels()
    private lateinit var binding: MainActivityBinding
    @Inject
    lateinit var imagesListAdapter: ImagesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initAdapter()
    }

    private fun initAdapter() {
        binding.rvMain.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,
            false)
        binding.rvMain.adapter = imagesListAdapter
        mainViewModel.dataList.observe(this, Observer {
            imagesListAdapter.submitList(it)
        })
    }
}