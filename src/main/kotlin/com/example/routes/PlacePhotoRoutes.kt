package com.example.routes

import com.example.feature.place_photo.controller.PlacePhotoController
import com.example.feature.place_photo.models.PlacePhotoCreate
import com.example.feature.region.controller.RegionController
import com.example.feature.region.models.RegionCreate
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.placePhotoRouting() {

    val placePhotoController: PlacePhotoController by inject()

    post("/place_photo") {
        val placePhoto = call.receive<PlacePhotoCreate>()

        val regionResponse = placePhotoController.create(placePhoto)
        call.respond(regionResponse.toString())
    }

    get("/place_photo/{id?}") {
        val id = call.parameters["id"] ?: return@get call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )

        LOGGER.trace(id)

        val regionResponse = placePhotoController.getById(id)
        call.respondText(regionResponse.toString())
    }

    delete("/place_photo/{id?}") {
        val id = call.parameters["id"] ?: return@delete call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )

        LOGGER.trace(id)

        val regionResponse = placePhotoController.delete(id)
        call.respondText(regionResponse.toString())
    }
}