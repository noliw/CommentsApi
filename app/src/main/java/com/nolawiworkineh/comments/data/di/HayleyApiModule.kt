package com.nolawiworkineh.comments.data.di

import com.nolawiworkineh.comments.data.network.HayleyApiService
import com.nolawiworkineh.comments.data.network.HayleyRetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HayleyApiModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit = HayleyRetrofitClient.retrofit

    @Provides
    @Singleton
    fun provideHayleyApiService(retrofit: Retrofit): HayleyApiService =
        retrofit.create(HayleyApiService::class.java)


}