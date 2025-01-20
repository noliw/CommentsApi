package com.nolawiworkineh.comments.domain

import com.nolawiworkineh.comments.data.network.HayleyCommentModel

interface CommentRepository {
    suspend fun fetchComments(): List<HayleyCommentModel>
}