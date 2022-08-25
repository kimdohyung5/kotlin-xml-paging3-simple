package com.kimdo.kotlin_xml_paging3_simple.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay

class SamplePagingSource( private val service: SampleBackendService) : PagingSource<Int, String>() {

    override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int, String> {
        return try {
            delay(500)

            val next = params.key ?: 0
            val response = service.getPagingData(next)

            LoadResult.Page(
                data = response.data,
                prevKey = if (next == 0) null else next - 1,
                nextKey = next + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, String>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}