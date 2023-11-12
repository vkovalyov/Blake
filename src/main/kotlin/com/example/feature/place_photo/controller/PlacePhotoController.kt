package com.example.feature.place_photo.controller

import com.example.feature.place_photo.models.PlacePhoto
import com.example.feature.place_photo.models.PlacePhotoCreate
import com.example.feature.place_photo.models.PlacePhotoResponse
import com.example.feature.region.models.Region
import com.example.feature.region.models.RegionCreate
import com.example.feature.region.models.RegionResponse

interface PlacePhotoController {
    suspend fun create(photo: PlacePhotoCreate): PlacePhotoResponse?

    suspend fun update(photo: PlacePhoto): PlacePhotoResponse?

    suspend fun delete(photoId: String): Boolean?

    suspend fun getById(photoId: String): PlacePhotoResponse?
}