package com.example.feature.place

import com.example.feature.place.controller.PlaceController
import com.example.feature.place.controller.PlaceControllerImpl
import com.example.feature.place.repository.PlaceRepository
import com.example.feature.place.repository.PlaceRepositoryImpl
import com.example.feature.place.service.PlaceService
import com.example.feature.place.service.PlaceServiceImpl
import com.example.feature.region.controller.RegionController
import com.example.feature.region.controller.RegionControllerImpl
import com.example.feature.region.repository.RegionRepository
import com.example.feature.region.repository.RegionRepositoryImpl
import com.example.feature.region.service.RegionService
import com.example.feature.region.service.RegionServiceImpl
import org.koin.dsl.module

private val controllerModules = module {
    single<PlaceController> { PlaceControllerImpl(get()) }
}

private val repositoryModules = module {
    single<PlaceRepository> { PlaceRepositoryImpl(get()) }
}

private val serviceModules = module {
    single<PlaceService> { PlaceServiceImpl(get()) }
}

val placeModules = listOf(controllerModules, repositoryModules, serviceModules)