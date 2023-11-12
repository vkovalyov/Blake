package com.example.feature.place.repository

import com.example.feature.place.models.Place
import com.example.feature.place.models.PlaceCreate
import com.example.feature.place.models.PlaceResponse
import com.example.feature.place.service.PlaceService
import com.example.feature.region.models.Region
import com.example.feature.region.models.RegionCreate
import com.example.feature.region.models.RegionResponse
import com.example.feature.region.service.RegionService

class PlaceRepositoryImpl(private val placeService: PlaceService
//, private val errorHandler: ExceptionHandler) :
):
    PlaceRepository {


    override suspend fun create(place: PlaceCreate): PlaceResponse? {
        return placeService.create(place)
    }

    override suspend fun update(place: Place): PlaceResponse? {
        return placeService.update(place)
    }

    override suspend fun delete(placeId: String): Boolean? {
        return placeService.delete(placeId)
    }

    override suspend fun getById(placeId: String): PlaceResponse? {
        return placeService.getById(placeId)
    }


}