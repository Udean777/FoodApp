package com.example.recipeapp.ui.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.data.ApiConfig
import com.example.recipeapp.state.RecipeState
import kotlinx.coroutines.launch
import java.lang.Exception

class RecipeViewModel: ViewModel() {
    private val _categoryState = mutableStateOf(RecipeState())
    val categoryState: State<RecipeState> = _categoryState

    init {
        fetchCategories()
    }

    private fun fetchCategories(){
        viewModelScope.launch {
            try {
                val res = ApiConfig.api.getCategories()
                _categoryState.value = _categoryState.value.copy(
                    list = res.categories,
                    loading = false,
                    error = null
                )
            }catch (e: Exception){
                _categoryState.value = _categoryState.value.copy(
                    loading = false,
                    error = "Error fetching categories ${e.message}"
                )

                e.message?.let { Log.e("Error", it) }
            }
        }
    }
}