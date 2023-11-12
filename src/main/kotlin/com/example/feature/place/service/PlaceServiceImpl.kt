package com.example.feature.place.service

import com.example.core.db.Database
import com.example.feature.place.models.Place
import com.example.feature.place.models.PlaceCreate
import com.example.feature.place.models.PlaceResponse
import com.example.feature.region.models.Region
import com.example.feature.region.models.RegionCreate
import com.example.feature.region.models.RegionResponse
import com.example.routes.LOGGER

class PlaceServiceImpl(private val database: Database) : PlaceService {

    // val id: String,
    //    val regionId: String = ObjectId().toString(),
    //    val placeTypeId: String = ObjectId().toString(),
    //    val previewPhotoId: String = ObjectId().toString(),
    //    val title: String,
    //    val description: String,
    //    val audioUrl: String,
    //    val lat: Double,
    //    val lon: Double,

    override suspend fun create(place: PlaceCreate): PlaceResponse? {

        val placeCreate = Place(
            regionId = place.regionId,
            placeTypeId = place.placeTypeId,
            previewPhotoId = place.previewPhotoId,
            title = place.title,
            description = place.description,
            audioUrl = place.audioUrl,
            lat = place.lat,
            lon = place.lon
        )
        return if (database.placeCollection.insertOne(placeCreate).wasAcknowledged()) {
            return PlaceResponse(
                id = placeCreate.id,
                regionId = placeCreate.regionId,
                placeTypeId = placeCreate.placeTypeId,
                previewPhotoId = placeCreate.previewPhotoId,
                title = placeCreate.title,
                description = placeCreate.description,
                audioUrl = placeCreate.audioUrl,
                lat = placeCreate.lat,
                lon = placeCreate.lon
            )
        } else null
    }

    override suspend fun update(place: Place): PlaceResponse? {
        return if (database.placeCollection.replaceOneById(id = place.id, replacement = place).wasAcknowledged()) {
            return PlaceResponse(
                id = place.id,
                regionId = place.regionId,
                placeTypeId = place.placeTypeId,
                previewPhotoId = place.previewPhotoId,
                title = place.title,
                description = place.description,
                audioUrl = place.audioUrl,
                lat = place.lat,
                lon = place.lon
            )
        } else null
    }

    override suspend fun delete(placeId: String): Boolean {
        return if (database.placeCollection.deleteOneById(id = placeId).wasAcknowledged()) {
            return true
        } else false
    }

    override suspend fun getById(placeId: String): PlaceResponse? {

        val place = (database.placeCollection.findOneById(placeId))

        if (place == null) {
            LOGGER.trace("region == null")
            return null
        }

        LOGGER.trace(place.title)

        return PlaceResponse(
            id = place.id,
            regionId = place.regionId,
            placeTypeId = place.placeTypeId,
            previewPhotoId = place.previewPhotoId,
            title = place.title,
            description = place.description,
            audioUrl = place.audioUrl,
            lat = place.lat,
            lon = place.lon
        )
    }


}