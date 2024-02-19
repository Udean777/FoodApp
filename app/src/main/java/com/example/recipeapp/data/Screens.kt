package com.example.recipeapp.data

sealed class Screens(val route: String){
    object RecipeScreen: Screens("recipescreen")
    object DetailScreen: Screens("detailscreen")
}