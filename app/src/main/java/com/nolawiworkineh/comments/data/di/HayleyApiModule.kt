package com.nolawiworkineh.comments.data.di

import com.nolawiworkineh.comments.data.network.CommentRepositoryImpl
import com.nolawiworkineh.comments.data.network.HayleyApiService
import com.nolawiworkineh.comments.data.network.HayleyRetrofitClient
import com.nolawiworkineh.comments.data.network.HayleyRetrofitClient.retrofit
import com.nolawiworkineh.comments.domain.CommentRepository
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

    @Provides
    @Singleton
    fun provideCommentRepositoryImpl(apiService: HayleyApiService): CommentRepository =
        CommentRepositoryImpl(apiService)


}