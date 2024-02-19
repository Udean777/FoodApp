package com.example.recipeapp.data

import com.example.recipeapp.data.model.Category
import retrofit2.http.GET

interface Api {
   @GET("categories.php")
   suspend fun getCategories(): Category

   companion object {
       const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
   }
}