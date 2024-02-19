package com.example.recipeapp.state

import com.example.recipeapp.data.model.Categories

data class RecipeState(
    val loading: Boolean = true,
    val list: List<Categories> = emptyList(),
    val error: String? = null
)
