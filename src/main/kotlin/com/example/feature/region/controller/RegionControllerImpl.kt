package com.example.feature.region.controller

import com.example.core.BaseResponse
import com.example.core.db.User
import com.example.core.errohandler.ExceptionHandler
import com.example.core.errohandler.MissingRequestBodyException
import com.example.feature.region.models.Region
import com.example.feature.region.models.RegionCreate
import com.example.feature.region.models.RegionResponse
import com.example.feature.region.repository.RegionRepository
import com.example.feature.user.repository.UserRepository
import io.ktor.server.application.*
import io.ktor.server.request.*


class RegionControllerImpl(private val orderRepository: RegionRepository
//, private val errorHandler: ExceptionHandler

) :
    RegionController {
    override suspend fun create(region: RegionCreate): RegionResponse? {
        return  orderRepository.create(region)
    }

    override suspend fun update(region: Region): RegionResponse? {
      return  orderRepository.update(region)
    }

    override suspend fun delete(regionId: String): Boolean? {
        return  orderRepository.delete(regionId)
    }

    override suspend fun getById(regionId: String): RegionResponse? {
       return  orderRepository.getById(regionId)
    }

}

suspend inline fun <reified T : Any> ApplicationCall.acceptOrThrowException(errorMessage: String): T {
    return this.receiveOrNull() ?: throw MissingRequestBodyException(errorMessage)
}

