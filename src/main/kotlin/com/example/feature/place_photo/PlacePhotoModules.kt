package com.example.feature.place_photo

import com.example.feature.place_photo.controller.PlacePhotoController
import com.example.feature.place_photo.controller.PlacePhotoControllerImpl
import com.example.feature.place_photo.repository.PlacePhotoRepository
import com.example.feature.place_photo.repository.PlacePhotoRepositoryImpl
import com.example.feature.place_photo.service.PlacePhotoService
import com.example.feature.place_photo.service.PlacePhotoServiceImpl
import com.example.feature.region.controller.RegionController
import com.example.feature.region.controller.RegionControllerImpl
import com.example.feature.region.repository.RegionRepository
import com.example.feature.region.repository.RegionRepositoryImpl
import com.example.feature.region.service.RegionService
import com.example.feature.region.service.RegionServiceImpl
import org.koin.dsl.module

private val controllerModules = module {
    single<PlacePhotoController> { PlacePhotoControllerImpl(get()) }
}

private val repositoryModules = module {
    single<PlacePhotoRepository> { PlacePhotoRepositoryImpl(get()) }
}

private val serviceModules = module {
    single<PlacePhotoService> { PlacePhotoServiceImpl(get()) }
}

val placePhotoModules = listOf(controllerModules, repositoryModules, serviceModules)