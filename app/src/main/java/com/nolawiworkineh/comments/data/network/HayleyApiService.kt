package com.nolawiworkineh.comments.data.network

import retrofit2.http.GET


interface HayleyApiService {
    @GET("comment")
    suspend fun getComment(): List<HayleyCommentModel>
}