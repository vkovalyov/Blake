package com.example.routes

import com.example.core.db.Customer
import com.example.feature.user.models.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.customerRouting() {
    route("/customer") {
        get {
            if (customerStorage.isNotEmpty()) {
                call.respond(customerStorage)
            } else {
                call.respondText("No customers found", status = HttpStatusCode.OK)
            }
        }


    }
}

fun Route.getCustomerRoute() {

    post {
        val customer = call.receive<Customer>()
        LOGGER.trace(customer.firstName)
    }

    post("/text") {
        val text = call.receiveText()
        call.respondText(text)
    }

    get("/customer/{id?}") {
        val id = call.parameters["id"] ?: return@get call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )

        call.respondText("Customer id = $id")
    }
}