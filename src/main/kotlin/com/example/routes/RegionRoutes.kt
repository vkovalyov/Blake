package com.example.routes

import com.example.feature.region.controller.RegionController
import com.example.feature.region.models.Region
import com.example.feature.region.models.RegionCreate
import com.example.feature.region.models.RegionResponse
import com.example.feature.region.models.RegionsResponse
import com.example.feature.region.service.RegionService
import com.google.gson.JsonParser
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import org.koin.ktor.ext.inject

fun Route.regionRouting() {

    val regionController: RegionController by inject()
    val regionService: RegionService by inject()

    post("/region") {
        val region = call.receive<RegionCreate>()

        // call.respondText("good answer")
        LOGGER.trace(region.name)
        val regionResponse = regionController.create(region)
        val post = Json.encodeToJsonElement(value = regionResponse)
        call.respond(post)
    }

    get("/region/{id?}") {
        val id = call.parameters["id"] ?: return@get call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )

        val regionResponse = regionController.getById(id)
        val post = Json.encodeToJsonElement(value = regionResponse)
        call.respond(post)
    }

    get("/regions") {
        val page = call.parameters["page"]?.toInt() ?: 0
        val limit = call.parameters["limit"]?.toInt() ?: 0

        val regionResponse = regionService.getAll(page, limit)
        val post = Json.encodeToJsonElement(value = regionResponse)
        call.respond(post)
    }

    get("/region/search") {
        val text = call.parameters["text"].toString()


        val regionResponse = regionService.findByName(text)
        val post = Json.encodeToJsonElement(value = regionResponse)
        call.respond(post)
    }

    put("/region") {
        val region = call.receive<Region>()

        LOGGER.trace(region.name)
        val regionResponse = regionController.update(region)
        val post = Json.encodeToJsonElement(value = regionResponse)
        call.respond(post)
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