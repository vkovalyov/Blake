package com.example.feature.user.service

import com.example.core.db.Database
import com.example.core.db.User

class UserServiceImpl(private val database: Database) : UserService {

    override suspend fun createUser(user: User, userId: String): UserService.UserResponse? {

        print("UserServiceImpl createUser")
       // val user = User(age = userResponse.age, name = userResponse.name)
        return if (database.userCollection.insertOne(user).wasAcknowledged()) {
            return UserService.UserResponse(age = user.age!!, name = user.name!!)
        } else null
    }


}