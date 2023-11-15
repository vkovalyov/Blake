package com.example.feature.region.service

import com.example.feature.region.models.Region
import com.example.feature.region.models.RegionCreate
import com.example.feature.region.models.RegionResponse
import com.example.feature.region.models.RegionsResponse


interface RegionService {

    suspend fun create(region: RegionCreate): RegionResponse?

    suspend fun update(region: Region): RegionResponse?

    suspend fun delete(regionId: String): Boolean?

    suspend fun getById(regionId: String): RegionResponse?

    suspend fun getAll(page: Int, limit: Int): RegionsResponse?

    suspend fun findByName(name: String): RegionsResponse?

}