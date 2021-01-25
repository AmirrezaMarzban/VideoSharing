package com.example.videosharing.model

import com.google.gson.annotations.SerializedName

data class Model(
    @SerializedName("thumbnail") var thumbnail: String,
    @SerializedName("url") var url: String
)