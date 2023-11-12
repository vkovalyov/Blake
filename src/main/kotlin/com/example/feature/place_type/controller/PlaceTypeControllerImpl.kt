package com.example.feature.place_type.controller

import com.example.core.errohandler.MissingRequestBodyException
import com.example.feature.place_reference.models.PlaceReference
import com.example.feature.place_reference.models.PlaceReferenceCreate
import com.example.feature.place_reference.models.PlaceReferenceResponse
import com.example.feature.place_reference.repository.PlaceReferenceRepository
import com.example.feature.place_type.models.PlaceType
import com.example.feature.place_type.models.PlaceTypeCreate
import com.example.feature.place_type.models.PlaceTypeResponse
import com.example.feature.place_type.repository.PlaceTypeRepository
import io.ktor.server.application.*
import io.ktor.server.request.*


class PlaceTypeControllerImpl(
    private val placeTypeRepository: PlaceTypeRepository
//, private val errorHandler: ExceptionHandler

) :
    PlaceTypeController {
    override suspend fun create(type: PlaceTypeCreate): PlaceTypeResponse? {
        return placeTypeRepository.create(type)
    }

    override suspend fun update(type: PlaceType): PlaceTypeResponse? {
        return placeTypeRepository.update(type)
    }

    override suspend fun delete(typeId: String): Boolean? {
        return placeTypeRepository.delete(typeId)
    }

    override suspend fun getById(typeId: String): PlaceTypeResponse? {
        return placeTypeRepository.getById(typeId)
    }

}

suspend inline fun <reified T : Any> ApplicationCall.acceptOrThrowException(errorMessage: String): T {
    return this.receiveOrNull() ?: throw MissingRequestBodyException(errorMessage)
}

