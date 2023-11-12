package com.example.feature.region

import com.example.feature.region.controller.RegionController
import com.example.feature.region.controller.RegionControllerImpl
import com.example.feature.region.repository.RegionRepository
import com.example.feature.region.repository.RegionRepositoryImpl
import com.example.feature.region.service.RegionService
import com.example.feature.region.service.RegionServiceImpl
import org.koin.dsl.module

private val controllerModules = module {
    single<RegionController> { RegionControllerImpl(get()) }
}

private val repositoryModules = module {
    single<RegionRepository> { RegionRepositoryImpl(get()) }
}

private val serviceModules = module {
    single<RegionService> { RegionServiceImpl(get()) }
}

val regionModules = listOf(controllerModules, repositoryModules, serviceModules)