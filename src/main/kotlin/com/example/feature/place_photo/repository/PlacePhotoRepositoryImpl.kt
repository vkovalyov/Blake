package com.example.feature.place_photo.repository

import com.example.feature.place_photo.models.PlacePhoto
import com.example.feature.place_photo.models.PlacePhotoCreate
import com.example.feature.place_photo.models.PlacePhotoResponse
import com.example.feature.place_photo.service.PlacePhotoService

class PlacePhotoRepositoryImpl(
    private val placePhotoService: PlacePhotoService
//, private val errorHandler: ExceptionHandler) :
) : PlacePhotoRepository {
    override suspend fun create(photo: PlacePhotoCreate): PlacePhotoResponse? {
        return placePhotoService.create(photo)
    }

    override suspend fun update(photo: PlacePhoto): PlacePhotoResponse? {
        return placePhotoService.update(photo)
    }

    override suspend fun delete(photoId: String): Boolean? {
        return placePhotoService.delete(photoId)
    }

    override suspend fun getById(photoId: String): PlacePhotoResponse? {
        return placePhotoService.getById(photoId)
    }
}