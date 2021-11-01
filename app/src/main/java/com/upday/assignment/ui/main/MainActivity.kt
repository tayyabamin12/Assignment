package com.upday.assignment.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.upday.assignment.R
import com.upday.assignment.databinding.MainActivityBinding
import com.upday.assignment.ui.adapter.ImagesListAdapter
import com.upday.assignment.utils.NetworkHelper
import com.upday.assignment.utils.State
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: MainActivityBinding

    @Inject
    lateinit var imagesListAdapter: ImagesListAdapter
    @Inject
    lateinit var networkHelper: NetworkHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViews()
        initAdapter()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initViews() {
        if (!networkHelper.isNetworkConnected()) {
            binding.fabRetry.visibility = View.VISIBLE
            showToast(resources.getString(R.string.please_check_internet))
        }

        binding.fabRetry.setOnClickListener {
            if (networkHelper.isNetworkConnected()) {
                mainViewModel.retry()
                imagesListAdapter.notifyDataSetChanged()
            }else {
                showToast(resources.getString(R.string.please_check_internet))
            }
        }
    }

    private fun initAdapter() {
        binding.rvMain.layoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL,
            false
        )
        binding.rvMain.adapter = imagesListAdapter
        mainViewModel.dataList.observe(this, {
            imagesListAdapter.submitList(it)
            setupObserver()
        })
    }

    private fun setupObserver() {
        mainViewModel.getState()?.observe(this, {
            if (it == null)
                return@observe
            when (it) {
                State.LOADING -> {
                    binding.loadingProgressbar.visibility = View.VISIBLE
                    binding.fabRetry.visibility = View.GONE
                }
                State.ERROR -> {
                    binding.loadingProgressbar.visibility = View.GONE
                    binding.fabRetry.visibility = View.VISIBLE
                    showToast(resources.getString(R.string.please_check_internet))
                }
                State.DONE -> {
                    binding.loadingProgressbar.visibility = View.GONE
                    binding.fabRetry.visibility = View.GONE
                }
            }
        })
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}