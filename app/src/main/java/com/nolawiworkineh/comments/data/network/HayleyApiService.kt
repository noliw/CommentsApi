package com.nolawiworkineh.comments.data.network

import retrofit2.http.GET


interface HayleyApiService {
    @GET("comments")
    suspend fun getComment(): List<HayleyCommentModel>
}