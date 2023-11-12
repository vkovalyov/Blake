package com.example.feature.place_reference.controller

import com.example.core.errohandler.MissingRequestBodyException
import com.example.feature.place_reference.models.PlaceReference
import com.example.feature.place_reference.models.PlaceReferenceCreate
import com.example.feature.place_reference.models.PlaceReferenceResponse
import com.example.feature.place_reference.repository.PlaceReferenceRepository
import io.ktor.server.application.*
import io.ktor.server.request.*


class PlaceReferenceControllerImpl(
    private val placeReferenceRepository: PlaceReferenceRepository
//, private val errorHandler: ExceptionHandler

) :
    PlaceReferenceController {
    override suspend fun create(reference: PlaceReferenceCreate): PlaceReferenceResponse? {
        return placeReferenceRepository.create(reference)
    }

    override suspend fun update(reference: PlaceReference): PlaceReferenceResponse? {
        return placeReferenceRepository.update(reference)
    }

    override suspend fun delete(referenceId: String): Boolean? {
        return placeReferenceRepository.delete(referenceId)
    }

    override suspend fun getById(referenceId: String): PlaceReferenceResponse? {
        return placeReferenceRepository.getById(referenceId)
    }

}

suspend inline fun <reified T : Any> ApplicationCall.acceptOrThrowException(errorMessage: String): T {
    return this.receiveOrNull() ?: throw MissingRequestBodyException(errorMessage)
}

