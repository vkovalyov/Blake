package com.example.feature.region.service

import com.example.core.db.Database
import com.example.core.db.User
import com.example.feature.region.models.Region
import com.example.feature.region.models.RegionCreate
import com.example.feature.region.models.RegionResponse
import com.example.feature.region.models.RegionsResponse
import com.example.feature.user.service.UserService
import com.example.routes.LOGGER
import com.mongodb.client.model.Filters
import com.mongodb.client.model.Indexes
import io.ktor.http.*
import io.ktor.util.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import org.bson.types.ObjectId

class RegionServiceImpl(private val database: Database) : RegionService {
    override suspend fun create(region: RegionCreate): RegionResponse? {

        val regionCreate = Region(name = region.name!!, coordinates = emptyList())
        return if (database.regionCollection.insertOne(regionCreate).wasAcknowledged()) {
            return RegionResponse(
                id = regionCreate.id,
                name = regionCreate.name,
                //coordinates = regionCreate.coordinates,
            )
        } else null
    }

    override suspend fun update(region: Region): RegionResponse? {
        return if (database.regionCollection.replaceOneById(id = region.id, replacement = region).wasAcknowledged()) {
            return RegionResponse(id = region.id, name = region.name) // coordinates = region.coordinates)
        } else null
    }

    override suspend fun delete(regionId: String): Boolean {
        return if (database.regionCollection.deleteOneById(id = regionId).wasAcknowledged()) {
            return true
        } else false
    }

    override suspend fun getById(regionId: String): RegionResponse? {

        val region = (database.regionCollection.findOneById(regionId))

        if (region == null) {
            LOGGER.trace("region == null")
            return null
        }

        LOGGER.trace(region.name)

        return RegionResponse(id = region.id, name = region.name)//, coordinates = region.coordinates)
    }

    override suspend fun getAll(page: Int, limit: Int): RegionsResponse? {
        var listOfRegionResponse = mutableListOf<RegionResponse>()

        val listOfRegions =
            database.regionCollection.find().skip(skip = (page - 1) * limit).limit(limit = limit).toList()

        listOfRegions.forEach {
            listOfRegionResponse.add(RegionResponse(id = it.id, name = it.name))
        }

        var regionsCount: Long = 0

        regionsCount = if (limit == 0 || page == 0) {
            listOfRegionResponse.size.toLong()
        } else {
            database.regionCollection.countDocuments()
        }



        return RegionsResponse(count = regionsCount, data = listOfRegionResponse)
    }

    override suspend fun findByName(name: String): RegionsResponse? {
        createIndexes() //todo  ???
        var listOfRegionResponse = mutableListOf<RegionResponse>()

        val filter = Filters.text(name)
        val listOfRegions = database.regionCollection.find(filter = filter).toList()

        listOfRegions.forEach {
            listOfRegionResponse.add(RegionResponse(id = it.id, name = it.name))
        }

        return RegionsResponse(count = listOfRegionResponse.size.toLong(), data = listOfRegionResponse)
    }

    suspend fun createIndexes() {
        database.regionCollection.createIndex(Indexes.text("name"))
    }


}

