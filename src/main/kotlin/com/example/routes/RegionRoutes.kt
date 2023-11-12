package com.example.routes

import com.example.feature.region.controller.RegionController
import com.example.feature.region.models.RegionCreate
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.regionRouting() {

    val regionController: RegionController by inject()

    post("/region") {
        val region = call.receive<RegionCreate>()

        // call.respondText("good answer")
        LOGGER.trace(region.name)
        val regionResponse = regionController.create(region)
        call.respond(regionResponse.toString())
    }

    get("/region/{id?}") {
        val id = call.parameters["id"] ?: return@get call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )

        LOGGER.trace(id)

        val regionResponse = regionController.getById(id)
        call.respondText(regionResponse.toString())
    }

    delete("/region/{id?}") {
        val id = call.parameters["id"] ?: return@delete call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )

        LOGGER.trace(id)

        val regionResponse = regionController.delete(id)
        call.respondText(regionResponse.toString())
    }
}