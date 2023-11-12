package com.example.feature.place_reference.controller

import com.example.feature.place_photo.models.PlacePhoto
import com.example.feature.place_photo.models.PlacePhotoCreate
import com.example.feature.place_photo.models.PlacePhotoResponse
import com.example.feature.place_reference.models.PlaceReference
import com.example.feature.place_reference.models.PlaceReferenceCreate
import com.example.feature.place_reference.models.PlaceReferenceResponse

interface PlaceReferenceController {
    suspend fun create(reference: PlaceReferenceCreate): PlaceReferenceResponse?

    suspend fun update(reference: PlaceReference): PlaceReferenceResponse?

    suspend fun delete(referenceId: String): Boolean?

    suspend fun getById(referenceId: String): PlaceReferenceResponse?
}