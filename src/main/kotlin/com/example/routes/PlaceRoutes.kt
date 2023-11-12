package com.example.routes

import com.example.feature.place.controller.PlaceController
import com.example.feature.place.models.PlaceCreate
import com.example.feature.place_type.controller.PlaceTypeController
import com.example.feature.place_type.models.PlaceTypeCreate
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.placeRouting() {

    val placeController: PlaceController by inject()

    post("/place") {
        val place = call.receive<PlaceCreate>()

        val regionResponse = placeController.create(place)
        call.respond(regionResponse.toString())
    }

    get("/place/{id?}") {
        val id = call.parameters["id"] ?: return@get call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )

        LOGGER.trace(id)

        val placeResponse = placeController.getById(id)
        call.respondText(placeResponse.toString())
    }

    delete("/place/{id?}") {
        val id = call.parameters["id"] ?: return@delete call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )

        LOGGER.trace(id)

        val placeResponse = placeController.delete(id)
        call.respondText(placeResponse.toString())
    }
}