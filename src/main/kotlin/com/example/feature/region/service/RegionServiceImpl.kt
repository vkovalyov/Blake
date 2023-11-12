package com.example.feature.region.service

import com.example.core.db.Database
import com.example.core.db.User
import com.example.feature.region.models.Region
import com.example.feature.region.models.RegionCreate
import com.example.feature.region.models.RegionResponse
import com.example.feature.user.service.UserService
import com.example.routes.LOGGER
import org.bson.types.ObjectId

class RegionServiceImpl(private val database: Database) : RegionService {
    override suspend fun create(region: RegionCreate): RegionResponse? {

        val regionCreate = Region(name = region.name!!, coordinates = emptyList())
        return if (database.regionCollection.insertOne(regionCreate).wasAcknowledged()) {
            return RegionResponse(
                id = regionCreate.id,
                name = regionCreate.name,
                coordinates = regionCreate.coordinates,
            )
        } else null
    }

    override suspend fun update(region: Region): RegionResponse? {
        return if (database.regionCollection.replaceOneById(id = region.id, replacement = region).wasAcknowledged()) {
            return RegionResponse(id = region.id, name = region.name, coordinates = region.coordinates)
        } else null
    }

    override suspend fun delete(regionId: String): Boolean {
        return if (database.regionCollection.deleteOneById(id = regionId).wasAcknowledged()) {
            return true
        } else false
    }

    override suspend fun getById(regionId: String): RegionResponse? {

        val region = (database.regionCollection.findOneById(regionId))

        if(region == null){
            LOGGER.trace("region == null")
            return  null
        }

        LOGGER.trace(region.name)

        return RegionResponse(id = region.id, name = region.name, coordinates = region.coordinates)
    }


}