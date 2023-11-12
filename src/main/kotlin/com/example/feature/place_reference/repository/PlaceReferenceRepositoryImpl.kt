package com.example.feature.place_reference.repository

import com.example.feature.place_photo.models.PlacePhoto
import com.example.feature.place_photo.models.PlacePhotoCreate
import com.example.feature.place_photo.models.PlacePhotoResponse
import com.example.feature.place_photo.service.PlacePhotoService
import com.example.feature.place_reference.models.PlaceReference
import com.example.feature.place_reference.models.PlaceReferenceCreate
import com.example.feature.place_reference.models.PlaceReferenceResponse
import com.example.feature.place_reference.service.PlaceReferenceService

class PlaceReferenceRepositoryImpl(
    private val placeReferenceService: PlaceReferenceService,
//, private val errorHandler: ExceptionHandler) :
) : PlaceReferenceRepository {
    override suspend fun create(reference: PlaceReferenceCreate): PlaceReferenceResponse? {
        return placeReferenceService.create(reference)
    }

    override suspend fun update(reference: PlaceReference): PlaceReferenceResponse? {
        return placeReferenceService.update(reference)
    }

    override suspend fun delete(referenceId: String): Boolean? {
        return placeReferenceService.delete(referenceId)
    }

    override suspend fun getById(referenceId: String): PlaceReferenceResponse? {
        return placeReferenceService.getById(referenceId)
    }
}