package com.kimdo.kotlin_xml_paging3_simple.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.kimdo.kotlin_xml_paging3_simple.data.PagingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PagingViewModel @Inject constructor(private val repository: PagingRepository) : ViewModel() {

    val pagingData = repository.getPagingData()
        .cachedIn(viewModelScope)

}