package com.example.feature.region.repository

import com.example.core.BaseResponse
import com.example.core.db.User
import com.example.core.errohandler.ExceptionHandler
import com.example.feature.region.models.Region
import com.example.feature.region.models.RegionCreate
import com.example.feature.region.models.RegionResponse
import com.example.feature.region.service.RegionService
import com.example.feature.user.service.UserService
import io.ktor.http.*

class RegionRepositoryImpl(private val orderService: RegionService
//, private val errorHandler: ExceptionHandler) :
):
    RegionRepository {
    override suspend fun create(region: RegionCreate): RegionResponse? {
        return orderService.create(region)
    }

    override suspend fun update(region: Region): RegionResponse? {
        return orderService.update(region)
    }

    override suspend fun delete(regionId: String): Boolean? {
        return orderService.delete(regionId)
    }

    override suspend fun getById(regionId: String): RegionResponse? {
        return orderService.getById(regionId)
    }


}