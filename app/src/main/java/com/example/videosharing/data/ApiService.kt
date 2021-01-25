package com.example.videosharing.data

import com.example.videosharing.model.Model
import io.reactivex.Single
import retrofit2.http.*

/**
 * Handle every HTTP request to retrofit by Gson and RXjava
 * @author Amirreza Marzban
 */

interface ApiService {

    @get:GET(HttpRequestUrl.GET_VIDEO)
    val getVideo: Single<MutableList<Model>>

}