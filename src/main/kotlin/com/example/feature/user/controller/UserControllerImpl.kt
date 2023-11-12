package com.example.feature.user.controller

import com.example.core.BaseResponse
import com.example.core.db.User
import com.example.core.errohandler.ExceptionHandler
import com.example.core.errohandler.MissingRequestBodyException
import com.example.feature.user.repository.UserRepository
import io.ktor.server.application.*
import io.ktor.server.request.*


class UserControllerImpl(private val orderRepository: UserRepository, private val errorHandler: ExceptionHandler) :
    UserController {

    override suspend fun createUser( user: User): BaseResponse<Any> {
       // val user = request.call.acceptOrThrowException<User>("Order body required")

        return  orderRepository.createUser(user, userId = "123")

    }
}
suspend inline fun <reified T : Any> ApplicationCall.acceptOrThrowException(errorMessage: String): T {
    return this.receiveOrNull() ?: throw MissingRequestBodyException(errorMessage)
}

/**
 * To extract user id from request call
 */
