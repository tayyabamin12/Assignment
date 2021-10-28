package com.upday.assignment.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.paging.PagingData
import com.upday.assignment.data.api.ApiHelper
import com.upday.assignment.data.api.ApiServiceImpl
import com.upday.assignment.data.base.ViewModelFactory
import com.upday.assignment.databinding.MainFragmentBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.upday.assignment.data.model.Data

import com.upday.assignment.ui.adapter.CustomAdapter
import com.upday.assignment.ui.adapter.NewsListAdapter


class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private var _binding: MainFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(ApiHelper(ApiServiceImpl()))
        )[MainViewModel::class.java]

        _binding = MainFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

//        setupObserver()
        initAdapter()
        return view
    }

    private lateinit var newsListAdapter: NewsListAdapter
    private fun initAdapter() {
        newsListAdapter = NewsListAdapter(requireContext())
        binding.rvMain.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.rvMain.adapter = newsListAdapter
        viewModel.dataList.observe(viewLifecycleOwner, Observer {
//            newsListAdapter.submitData(PagingData.from(it.data))
            newsListAdapter.submitList(it)
        })
    }

    private fun setRecyclerView(data: List<Data>) {
        val arrayList = arrayListOf("one", "two")
        binding.rvMain.apply {
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = CustomAdapter(requireContext(), data)
        }
    }

    private fun setupObserver() {
        viewModel.getImagesResponse().observe(viewLifecycleOwner, {
            if (it != null) {
                setRecyclerView(it.data)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}