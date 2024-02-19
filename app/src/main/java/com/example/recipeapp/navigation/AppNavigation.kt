package com.example.recipeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.recipeapp.data.Screens
import com.example.recipeapp.data.model.Categories
import com.example.recipeapp.ui.screens.CategoryDetailScreen
import com.example.recipeapp.ui.screens.RecipeScreen
import com.example.recipeapp.ui.viewModel.RecipeViewModel

@Composable
fun AppNavigation(navController: NavHostController) {
    val recipeViewModel: RecipeViewModel = viewModel()
    val viewState by recipeViewModel.categoryState

    NavHost(navController = navController, startDestination = Screens.RecipeScreen.route ){
        composable(route = Screens.RecipeScreen.route){
            RecipeScreen(navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("any", it)
                navController.navigate(Screens.DetailScreen.route)
            }, viewState = viewState)
        }

        composable(route = Screens.DetailScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Categories>("any")
                ?: Categories(
                    "",
                    "",
                    "",
                    ""
                )
            CategoryDetailScreen(category = category)
        }
    }
}