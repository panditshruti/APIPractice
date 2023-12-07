package com.shrutipandit.alarmsk

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("v1/sample-data/photos")
    fun getPhotos(): Call<List<Photo>>
}
