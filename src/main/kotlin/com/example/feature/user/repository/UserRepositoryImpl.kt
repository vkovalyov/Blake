package com.example.feature.user.repository

import com.example.core.BaseResponse
import com.example.core.db.User
import com.example.core.errohandler.ExceptionHandler
import com.example.feature.user.service.UserService
import io.ktor.http.*

class UserRepositoryImpl(private val orderService: UserService, private val errorHandler: ExceptionHandler) :
    UserRepository {

    override suspend fun createUser(user: User, userId: String): BaseResponse<Any> {
        val response: UserService.UserResponse? = orderService.createUser(user, userId)
        if (response != null) {
            return BaseResponse.SuccessResponse(statusCode = HttpStatusCode.Created, data = response)
        } else {
            throw errorHandler.respondGenericException()
        }
    }

}