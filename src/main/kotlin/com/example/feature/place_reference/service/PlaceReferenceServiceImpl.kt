package com.example.feature.place_reference.service

import com.example.core.db.Database
import com.example.feature.place_photo.models.PlacePhoto
import com.example.feature.place_photo.models.PlacePhotoCreate
import com.example.feature.place_photo.models.PlacePhotoResponse
import com.example.feature.place_reference.models.PlaceReference
import com.example.feature.place_reference.models.PlaceReferenceCreate
import com.example.feature.place_reference.models.PlaceReferenceResponse
import com.example.routes.LOGGER

class PlaceReferenceServiceImpl(private val database: Database) : PlaceReferenceService {
    override suspend fun create(reference: PlaceReferenceCreate): PlaceReferenceResponse? {

        val newReference =
            PlaceReference(
                placeId = reference.placeId,
                referenceUrl = reference.referenceUrl,
                title = reference.title
            )
        return if (database.placeReferenceCollection.insertOne(newReference).wasAcknowledged()) {
            return PlaceReferenceResponse(
                id = newReference.id,
                placeId = newReference.placeId,
                referenceUrl = newReference.referenceUrl,
                title = newReference.title
            )
        } else null
    }

    override suspend fun update(reference: PlaceReference): PlaceReferenceResponse? {
        return if (database.placeReferenceCollection.replaceOneById(id = reference.id, replacement = reference)
                .wasAcknowledged()
        ) {
            return PlaceReferenceResponse(
                id = reference.id,
                placeId = reference.placeId,
                referenceUrl = reference.referenceUrl,
                title = reference.title
            )
        } else null
    }

    override suspend fun delete(referenceId: String): Boolean {
        return if (database.placeReferenceCollection.deleteOneById(id = referenceId).wasAcknowledged()) {
            return true
        } else false
    }

    override suspend fun getById(referenceId: String): PlaceReferenceResponse? {

        val reference = (database.placeReferenceCollection.findOneById(referenceId))

        if (reference == null) {
            LOGGER.trace("region == null")
            return null
        }


        return PlaceReferenceResponse(
            id = reference.id,
            placeId = reference.placeId,
            referenceUrl = reference.referenceUrl,
            title = reference.title
        )
    }


}