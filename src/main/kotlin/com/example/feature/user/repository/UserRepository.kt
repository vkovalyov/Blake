package com.example.feature.user.repository

import com.example.core.BaseResponse
import com.example.core.db.User

interface UserRepository {


    suspend fun createUser(user: User, userId: String): BaseResponse<Any>

}