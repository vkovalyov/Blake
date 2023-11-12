package com.example.feature.place_type.controller

import com.example.feature.place_reference.models.PlaceReference
import com.example.feature.place_reference.models.PlaceReferenceCreate
import com.example.feature.place_reference.models.PlaceReferenceResponse
import com.example.feature.place_type.models.PlaceType
import com.example.feature.place_type.models.PlaceTypeCreate
import com.example.feature.place_type.models.PlaceTypeResponse

interface PlaceTypeController {
    suspend fun create(type: PlaceTypeCreate): PlaceTypeResponse?

    suspend fun update(type: PlaceType): PlaceTypeResponse?

    suspend fun delete(typeId: String): Boolean?

    suspend fun getById(typeId: String): PlaceTypeResponse?
}