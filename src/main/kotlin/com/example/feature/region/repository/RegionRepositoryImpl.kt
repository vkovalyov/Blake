package com.example.feature.region.repository

import com.example.core.BaseResponse
import com.example.core.db.User
import com.example.core.errohandler.ExceptionHandler
import com.example.feature.region.models.Region
import com.example.feature.region.models.RegionCreate
import com.example.feature.region.models.RegionResponse
import com.example.feature.region.models.RegionsResponse
import com.example.feature.region.service.RegionService
import com.example.feature.user.service.UserService
import io.ktor.http.*

class RegionRepositoryImpl(
    private val regionService: RegionService
//, private val errorHandler: ExceptionHandler) :
) :
    RegionRepository {
    override suspend fun create(region: RegionCreate): RegionResponse? {
        return regionService.create(region)
    }

    override suspend fun update(region: Region): RegionResponse? {
        return regionService.update(region)
    }

    override suspend fun delete(regionId: String): Boolean? {
        return regionService.delete(regionId)
    }

    override suspend fun getById(regionId: String): RegionResponse? {
        return regionService.getById(regionId)
    }

    override suspend fun getAll(page: Int, limit: Int): RegionsResponse? {
        return regionService.getAll(page, limit)
    }


}