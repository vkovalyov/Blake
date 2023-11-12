package com.example.feature.place.controller

import com.example.core.errohandler.MissingRequestBodyException
import com.example.feature.place.models.Place
import com.example.feature.place.models.PlaceCreate
import com.example.feature.place.models.PlaceResponse
import com.example.feature.place.repository.PlaceRepository
import com.example.feature.region.models.Region
import com.example.feature.region.models.RegionCreate
import com.example.feature.region.models.RegionResponse
import com.example.feature.region.repository.RegionRepository
import io.ktor.server.application.*
import io.ktor.server.request.*


class PlaceControllerImpl(
    private val placeRepository: PlaceRepository
//, private val errorHandler: ExceptionHandler

) :
    PlaceController {
    override suspend fun create(place: PlaceCreate): PlaceResponse? {
        return placeRepository.create(place)
    }

    override suspend fun update(place: Place): PlaceResponse? {
        return placeRepository.update(place)
    }

    override suspend fun delete(placeId: String): Boolean? {
        return placeRepository.delete(placeId)
    }

    override suspend fun getById(placeId: String): PlaceResponse? {
        return placeRepository.getById(placeId)
    }

}

suspend inline fun <reified T : Any> ApplicationCall.acceptOrThrowException(errorMessage: String): T {
    return this.receiveOrNull() ?: throw MissingRequestBodyException(errorMessage)
}

