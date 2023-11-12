package com.example.routes

import com.example.feature.place_photo.controller.PlacePhotoController
import com.example.feature.place_photo.models.PlacePhotoCreate
import com.example.feature.place_reference.controller.PlaceReferenceController
import com.example.feature.place_reference.models.PlaceReferenceCreate
import com.example.feature.region.controller.RegionController
import com.example.feature.region.models.RegionCreate
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.placeReferenceRouting() {

    val placeReferenceController: PlaceReferenceController by inject()

    post("/place_reference") {
        val placeReference = call.receive<PlaceReferenceCreate>()

        val regionResponse = placeReferenceController.create(placeReference)
        call.respond(regionResponse.toString())
    }

    get("/place_reference/{id?}") {
        val id = call.parameters["id"] ?: return@get call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )

        LOGGER.trace(id)

        val regionResponse = placeReferenceController.getById(id)
        call.respondText(regionResponse.toString())
    }

    delete("/place_reference/{id?}") {
        val id = call.parameters["id"] ?: return@delete call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )

        LOGGER.trace(id)

        val regionResponse = placeReferenceController.delete(id)
        call.respondText(regionResponse.toString())
    }
}