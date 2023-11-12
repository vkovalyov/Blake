package com.example.feature.place_photo.service

import com.example.core.db.Database
import com.example.feature.place_photo.models.PlacePhoto
import com.example.feature.place_photo.models.PlacePhotoCreate
import com.example.feature.place_photo.models.PlacePhotoResponse
import com.example.feature.region.models.Region
import com.example.feature.region.models.RegionCreate
import com.example.feature.region.models.RegionResponse
import com.example.routes.LOGGER

class PlacePhotoServiceImpl(private val database: Database) : PlacePhotoService {
    override suspend fun create(photoCreate: PlacePhotoCreate): PlacePhotoResponse? {

        val photo = PlacePhoto(placeId = photoCreate.placeId, photoUrl = photoCreate.photoUrl)
        return if (database.placePhotoCollection.insertOne(photo).wasAcknowledged()) {
            return PlacePhotoResponse(id = photo.id, placeId = photo.placeId, photoUrl = photo.photoUrl)
        } else null
    }

    override suspend fun update(photo: PlacePhoto): PlacePhotoResponse? {
        return if (database.placePhotoCollection.replaceOneById(id = photo.id, replacement = photo)
                .wasAcknowledged()
        ) {
            return PlacePhotoResponse(id = photo.id, placeId = photo.placeId, photoUrl = photo.photoUrl)
        } else null
    }

    override suspend fun delete(photoId: String): Boolean {
        return if (database.placePhotoCollection.deleteOneById(id = photoId).wasAcknowledged()) {
            return true
        } else false
    }

    override suspend fun getById(photoId: String): PlacePhotoResponse? {

        val photo = (database.placePhotoCollection.findOneById(photoId))

        if (photo == null) {
            LOGGER.trace("region == null")
            return null
        }


        return PlacePhotoResponse(id = photo.id, placeId = photo.placeId, photoUrl = photo.photoUrl)
    }


}