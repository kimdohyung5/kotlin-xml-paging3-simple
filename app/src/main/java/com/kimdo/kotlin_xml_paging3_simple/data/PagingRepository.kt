package com.kimdo.kotlin_xml_paging3_simple.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kimdo.kotlin_xml_paging3_simple.utils.Constants
import kotlinx.coroutines.flow.Flow

class PagingRepository constructor(private val service: SampleBackendService) {
    fun getPagingData(): Flow<PagingData<String>> {
        return Pager( PagingConfig(pageSize = Constants.PAGE_SIZE)) {
            SamplePagingSource(service)
        }.flow
    }
}