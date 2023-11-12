package com.example.feature.place_photo.controller

import com.example.core.errohandler.MissingRequestBodyException
import com.example.feature.place_photo.models.PlacePhoto
import com.example.feature.place_photo.models.PlacePhotoCreate
import com.example.feature.place_photo.models.PlacePhotoResponse
import com.example.feature.place_photo.repository.PlacePhotoRepository
import com.example.feature.region.models.Region
import com.example.feature.region.models.RegionCreate
import com.example.feature.region.models.RegionResponse
import com.example.feature.region.repository.RegionRepository
import io.ktor.server.application.*
import io.ktor.server.request.*


class PlacePhotoControllerImpl(
    private val placePhotoRepository: PlacePhotoRepository
//, private val errorHandler: ExceptionHandler

) :
    PlacePhotoController {
    override suspend fun create(photo: PlacePhotoCreate): PlacePhotoResponse? {
        return placePhotoRepository.create(photo)
    }

    override suspend fun update(photo: PlacePhoto): PlacePhotoResponse? {
        return placePhotoRepository.update(photo)
    }

    override suspend fun delete(photoId: String): Boolean? {
        return placePhotoRepository.delete(photoId)
    }

    override suspend fun getById(photoId: String): PlacePhotoResponse? {
        return placePhotoRepository.getById(photoId)
    }

}

suspend inline fun <reified T : Any> ApplicationCall.acceptOrThrowException(errorMessage: String): T {
    return this.receiveOrNull() ?: throw MissingRequestBodyException(errorMessage)
}

