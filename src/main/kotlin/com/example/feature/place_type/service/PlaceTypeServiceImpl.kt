package com.example.feature.place_type.service

import com.example.core.db.Database
import com.example.feature.place_reference.models.PlaceReference
import com.example.feature.place_reference.models.PlaceReferenceCreate
import com.example.feature.place_reference.models.PlaceReferenceResponse
import com.example.feature.place_type.models.PlaceType
import com.example.feature.place_type.models.PlaceTypeCreate
import com.example.feature.place_type.models.PlaceTypeResponse
import com.example.routes.LOGGER

class PlaceTypeServiceImpl(private val database: Database) : PlaceTypeService {
    override suspend fun create(type: PlaceTypeCreate): PlaceTypeResponse? {

        val newReference =
            PlaceType(
                name = type.name,
                iconUrl = type.iconUrl,
            )
        return if (database.placeTypeCollection.insertOne(newReference).wasAcknowledged()) {
            return PlaceTypeResponse(
                id = newReference.id,
                name = newReference.name,
                iconUrl = newReference.iconUrl,

                )
        } else null
    }

    override suspend fun update(type: PlaceType): PlaceTypeResponse? {
        return if (database.placeTypeCollection.replaceOneById(id = type.id, replacement = type)
                .wasAcknowledged()
        ) {
            return PlaceTypeResponse(
                id = type.id,
                name = type.name,
                iconUrl = type.iconUrl,
            )
        } else null
    }

    override suspend fun delete(typeId: String): Boolean {
        return if (database.placeTypeCollection.deleteOneById(id = typeId).wasAcknowledged()) {
            return true
        } else false
    }

    override suspend fun getById(typeId: String): PlaceTypeResponse? {

        val reference = (database.placeTypeCollection.findOneById(typeId))

        if (reference == null) {
            LOGGER.trace("region == null")
            return null
        }


        return PlaceTypeResponse(
            id = reference.id,
            name = reference.name,
            iconUrl = reference.iconUrl,
        )
    }


}