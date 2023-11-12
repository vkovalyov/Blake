package com.example.routes

import com.example.feature.place_type.controller.PlaceTypeController
import com.example.feature.place_type.models.PlaceTypeCreate
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.placeTypeRouting() {

    val placeTypeController: PlaceTypeController by inject()

    post("/place_type") {
        val placeType = call.receive<PlaceTypeCreate>()

        val regionResponse = placeTypeController.create(placeType)
        call.respond(regionResponse.toString())
    }

    get("/place_type/{id?}") {
        val id = call.parameters["id"] ?: return@get call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )

        LOGGER.trace(id)

        val typeResponse = placeTypeController.getById(id)
        call.respondText(typeResponse.toString())
    }

    delete("/place_type/{id?}") {
        val id = call.parameters["id"] ?: return@delete call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )

        LOGGER.trace(id)

        val typeResponse = placeTypeController.delete(id)
        call.respondText(typeResponse.toString())
    }
}