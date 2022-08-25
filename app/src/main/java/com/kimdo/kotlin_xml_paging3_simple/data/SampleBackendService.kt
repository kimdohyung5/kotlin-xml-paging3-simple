package com.kimdo.kotlin_xml_paging3_simple.data

import com.kimdo.kotlin_xml_paging3_simple.domain.PagingSample
import com.kimdo.kotlin_xml_paging3_simple.utils.Constants

class SampleBackendService {

    fun getPagingData(page: Int): PagingSample {
        val result = mutableListOf<String>()

        val start = page * Constants.PAGE_SIZE
        for( i in start until start + Constants.PAGE_SIZE) {
            result.add("$i item")
        }

        return PagingSample(
            data = result,
            page = page + 1
        )
    }
}