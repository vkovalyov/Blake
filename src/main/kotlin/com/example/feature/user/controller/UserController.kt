package com.example.feature.user.controller

import com.example.core.BaseResponse
import com.example.core.db.User

interface UserController {
    suspend fun createUser(user: User): BaseResponse<Any>

}