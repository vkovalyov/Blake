package com.example.plugins

import com.example.routes.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        customerRouting()
        getCustomerRoute()
        userRouting()
        regionRouting()
        placePhotoRouting()
        placeReferenceRouting()
        placeTypeRouting()
        placeRouting()
    }
}
