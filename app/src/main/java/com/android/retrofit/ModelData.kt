package com.android.retrofit

import com.squareup.moshi.Json

data class ModelData(
    val id: String,
    @Json(name = "img_src") val imgSrcUrl: String,
    val type: String,
    val price: Double
)
