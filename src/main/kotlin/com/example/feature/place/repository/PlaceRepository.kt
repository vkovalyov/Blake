package com.example.feature.place.repository

import com.example.feature.place.models.Place
import com.example.feature.place.models.PlaceCreate
import com.example.feature.place.models.PlaceResponse
import com.example.feature.region.models.Region
import com.example.feature.region.models.RegionCreate
import com.example.feature.region.models.RegionResponse

interface PlaceRepository {
    suspend fun create(place: PlaceCreate): PlaceResponse?

    suspend fun update(place: Place): PlaceResponse?

    suspend fun delete(placeId: String): Boolean?

    suspend fun getById(placeId: String): PlaceResponse?

}