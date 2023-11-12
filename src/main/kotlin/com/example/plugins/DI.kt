package com.example.plugins

import com.example.core.coreModules
import com.example.core.userModules
import com.example.feature.place.placeModules
import com.example.feature.place_photo.placePhotoModules
import com.example.feature.place_reference.placeReferenceModules
import com.example.feature.place_type.placeTypeModules
import com.example.feature.region.regionModules
import com.example.module
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin() {
    install(Koin) {
       // slf4jLogger()
        modules(coreModules)
        modules(regionModules)
        modules(placePhotoModules)
        modules(placeReferenceModules)
        modules(placeTypeModules)
        modules(placeModules)
    }
}