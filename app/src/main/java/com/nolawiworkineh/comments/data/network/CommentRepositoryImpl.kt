package com.nolawiworkineh.comments.data.network

import android.util.Log
import com.nolawiworkineh.comments.domain.CommentRepository
import java.util.concurrent.CancellationException
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val hayleyApi: HayleyApiService
) : CommentRepository {
    override suspend fun fetchComments(): List<HayleyCommentModel> {
        return try {
            hayleyApi.getComment()
        } catch (e: Exception) {
            when (e) {
                is CancellationException -> throw e
                else -> {
                    Log.e("DataRepositoryImpl", "Error fetching data: ${e.message}")
                }
            }
            emptyList()
        }
    }
}