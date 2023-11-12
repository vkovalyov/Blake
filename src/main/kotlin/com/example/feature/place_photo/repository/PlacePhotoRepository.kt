package com.example.feature.place_photo.repository

import com.example.feature.place_photo.models.PlacePhoto
import com.example.feature.place_photo.models.PlacePhotoCreate
import com.example.feature.place_photo.models.PlacePhotoResponse

interface PlacePhotoRepository {
    suspend fun create(photo: PlacePhotoCreate): PlacePhotoResponse?

    suspend fun update(photo: PlacePhoto): PlacePhotoResponse?

    suspend fun delete(photoId: String): Boolean?

    suspend fun getById(photoId: String): PlacePhotoResponse?

}