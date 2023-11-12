package com.example.feature.place_reference

import com.example.feature.place_photo.controller.PlacePhotoController
import com.example.feature.place_photo.controller.PlacePhotoControllerImpl
import com.example.feature.place_photo.repository.PlacePhotoRepository
import com.example.feature.place_photo.repository.PlacePhotoRepositoryImpl
import com.example.feature.place_photo.service.PlacePhotoService
import com.example.feature.place_photo.service.PlacePhotoServiceImpl
import com.example.feature.place_reference.controller.PlaceReferenceController
import com.example.feature.place_reference.controller.PlaceReferenceControllerImpl
import com.example.feature.place_reference.repository.PlaceReferenceRepository
import com.example.feature.place_reference.repository.PlaceReferenceRepositoryImpl
import com.example.feature.place_reference.service.PlaceReferenceService
import com.example.feature.place_reference.service.PlaceReferenceServiceImpl
import com.example.feature.region.controller.RegionController
import com.example.feature.region.controller.RegionControllerImpl
import com.example.feature.region.repository.RegionRepository
import com.example.feature.region.repository.RegionRepositoryImpl
import com.example.feature.region.service.RegionService
import com.example.feature.region.service.RegionServiceImpl
import org.koin.dsl.module

private val controllerModules = module {
    single<PlaceReferenceController> { PlaceReferenceControllerImpl(get()) }
}

private val repositoryModules = module {
    single<PlaceReferenceRepository> { PlaceReferenceRepositoryImpl(get()) }
}

private val serviceModules = module {
    single<PlaceReferenceService> { PlaceReferenceServiceImpl(get()) }
}

val placeReferenceModules = listOf(controllerModules, repositoryModules, serviceModules)