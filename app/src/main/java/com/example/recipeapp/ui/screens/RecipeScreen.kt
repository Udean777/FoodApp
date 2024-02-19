package com.example.recipeapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.recipeapp.data.model.Categories
import com.example.recipeapp.state.RecipeState

@Composable
fun RecipeScreen(
    navigateToDetail: (Categories) -> Unit,
    viewState: RecipeState
) {

    Box(modifier = Modifier.fillMaxSize()){
        when{
            viewState.loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.fillMaxSize()
                    .align(Alignment.Center)
                )
            }

            viewState.error !== null -> {
                Text(
                    text = "Data not found",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center)
                )
            }

            else -> {
                CategoryScreen(categories = viewState.list, navigateToDetail)
            }
        }
    }
}