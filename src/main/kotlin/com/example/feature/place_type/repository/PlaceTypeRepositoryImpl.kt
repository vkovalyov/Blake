package com.example.feature.place_type.repository

import com.example.feature.place_reference.models.PlaceReference
import com.example.feature.place_reference.models.PlaceReferenceCreate
import com.example.feature.place_reference.models.PlaceReferenceResponse
import com.example.feature.place_reference.service.PlaceReferenceService
import com.example.feature.place_type.models.PlaceType
import com.example.feature.place_type.models.PlaceTypeCreate
import com.example.feature.place_type.models.PlaceTypeResponse
import com.example.feature.place_type.service.PlaceTypeService

class PlaceTypeRepositoryImpl(
    private val placeTypeService: PlaceTypeService,
//, private val errorHandler: ExceptionHandler) :
) : PlaceTypeRepository {
    override suspend fun create(type: PlaceTypeCreate): PlaceTypeResponse? {
        return placeTypeService.create(type)
    }

    override suspend fun update(type: PlaceType): PlaceTypeResponse? {
        return placeTypeService.update(type)
    }

    override suspend fun delete(typeId: String): Boolean? {
        return placeTypeService.delete(typeId)
    }

    override suspend fun getById(typeId: String): PlaceTypeResponse? {
        return placeTypeService.getById(typeId)
    }
}