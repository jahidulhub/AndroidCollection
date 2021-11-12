package com.android.retrofit

import retrofit2.http.GET

interface ApiService {
    @GET("realestate")
    suspend fun getProperties(): List<ModelData>
}