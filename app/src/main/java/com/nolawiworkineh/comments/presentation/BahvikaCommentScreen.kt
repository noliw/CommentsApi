package com.nolawiworkineh.comments.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun BahvikaCommentScreen(
    viewModel: BhavikaCommentViewModel = hiltViewModel(),
    modifier: Modifier = Modifier

) {

    LaunchedEffect(Unit) {
        viewModel.fetchHayleyComment()
    }


    val data = viewModel.uiState
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(data) { comments ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = 0f
                        )
                    )
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = "${comments.id}",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall,
                )

                Text(
                    text = comments.name,
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall,
                )

                Text(
                    text = comments.email,
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall,
                )
                Text(
                    text = comments.body,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {

}