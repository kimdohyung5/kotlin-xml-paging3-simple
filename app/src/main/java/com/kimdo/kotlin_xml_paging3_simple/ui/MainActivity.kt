package com.kimdo.kotlin_xml_paging3_simple.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.kimdo.kotlin_xml_paging3_simple.PagingAdapter
import com.kimdo.kotlin_xml_paging3_simple.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    private val pagingAdapter: PagingAdapter by lazy { PagingAdapter() }

    private val viewModel: PagingViewModel by viewModels()

    private var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )

        binding.rvView.adapter = pagingAdapter


        job?.cancel()
        job = lifecycleScope.launch {
            viewModel.pagingData.collectLatest {
                pagingAdapter.submitData(it)
            }
        }

        binding.swRefresh.setOnRefreshListener {
            pagingAdapter.refresh()
            binding.swRefresh.isRefreshing = false
        }
    }
}