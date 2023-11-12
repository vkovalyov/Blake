package com.example.core

import com.example.feature.user.controller.UserController
import com.example.feature.user.controller.UserControllerImpl
import com.example.feature.user.repository.UserRepository
import com.example.feature.user.repository.UserRepositoryImpl
import com.example.feature.user.service.UserService
import com.example.feature.user.service.UserServiceImpl
import org.koin.dsl.module

private val controllerModules = module {
    single<UserController> { UserControllerImpl(get(), get()) }
}

private val repositoryModules = module {
    single<UserRepository> { UserRepositoryImpl(get(), get()) }
}

private val serviceModules = module {
    single<UserService> { UserServiceImpl(get()) }
}

val userModules = listOf(controllerModules, repositoryModules, serviceModules)