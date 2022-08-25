package com.kimdo.kotlin_xml_paging3_simple.di

import com.kimdo.kotlin_xml_paging3_simple.data.PagingRepository
import com.kimdo.kotlin_xml_paging3_simple.data.SampleBackendService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideBackendService() : SampleBackendService {
        return SampleBackendService()
    }

    @Singleton
    @Provides
    fun providePagingRepository( service: SampleBackendService): PagingRepository {
        return PagingRepository(service)
    }
}