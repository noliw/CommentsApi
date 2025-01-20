package com.nolawiworkineh.comments.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nolawiworkineh.comments.data.network.HayleyCommentModel
import com.nolawiworkineh.comments.domain.CommentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BhavikaCommentViewModel @Inject constructor(
    private val commentRepository: CommentRepository
): ViewModel() {

    var uiState by mutableStateOf<List<HayleyCommentModel>>(emptyList())
        private set

    fun fetchHayleyComment(){
        viewModelScope.launch {
            uiState = commentRepository.fetchComments()
        }
    }
}