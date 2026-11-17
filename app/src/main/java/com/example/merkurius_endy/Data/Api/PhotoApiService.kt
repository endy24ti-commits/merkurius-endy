package com.example.merkurius_endy.Data.Api

import com.example.merkurius_endy.Data.Model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}