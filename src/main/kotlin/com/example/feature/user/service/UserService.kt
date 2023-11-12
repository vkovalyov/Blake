package com.example.feature.user.service

import com.example.core.db.User


interface UserService {

    suspend fun createUser(user: User, userId: String): UserResponse?

    data class UserResponse(
        val age: Int,
        val name: String,
    )
}