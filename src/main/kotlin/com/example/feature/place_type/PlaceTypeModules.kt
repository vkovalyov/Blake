package com.example.feature.place_type

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
import com.example.feature.place_type.controller.PlaceTypeController
import com.example.feature.place_type.controller.PlaceTypeControllerImpl
import com.example.feature.place_type.repository.PlaceTypeRepository
import com.example.feature.place_type.repository.PlaceTypeRepositoryImpl
import com.example.feature.place_type.service.PlaceTypeService
import com.example.feature.place_type.service.PlaceTypeServiceImpl
import com.example.feature.region.controller.RegionController
import com.example.feature.region.controller.RegionControllerImpl
import com.example.feature.region.repository.RegionRepository
import com.example.feature.region.repository.RegionRepositoryImpl
import com.example.feature.region.service.RegionService
import com.example.feature.region.service.RegionServiceImpl
import org.koin.dsl.module

private val controllerModules = module {
    single<PlaceTypeController> { PlaceTypeControllerImpl(get()) }
}

private val repositoryModules = module {
    single<PlaceTypeRepository> { PlaceTypeRepositoryImpl(get()) }
}

private val serviceModules = module {
    single<PlaceTypeService> { PlaceTypeServiceImpl(get()) }
}

val placeTypeModules = listOf(controllerModules, repositoryModules, serviceModules)