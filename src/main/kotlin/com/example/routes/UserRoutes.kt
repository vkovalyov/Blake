package com.example.routes
import com.example.feature.user.controller.UserControllerImpl
import com.example.core.db.DataBaseImpl
import com.example.core.db.User
import com.example.core.errohandler.ExceptionHandlerImpl
import com.example.feature.user.repository.UserRepositoryImpl
import com.example.feature.user.service.UserServiceImpl
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.logging.*
import kotlin.io.print

internal val LOGGER = KtorSimpleLogger("com.example.Blake")
fun Route.userRouting() {
    route("/user") {

        get {
            LOGGER.trace("HEEELOO")
            call.respondText("user get i")
        }

        post {

            val customer = call.receive<User>()
            LOGGER.trace(customer.name)

//           // val user = call.receive<User>()
//            LOGGER.trace("EEELOO")
//            print("1")
//            var database = DataBaseImpl("codex")
//            print("2")
//            var service = UserServiceImpl(database= database)
//            print("3")
//            var repository = UserRepositoryImpl(orderService = service, errorHandler = ExceptionHandlerImpl())
//            print("4")
//            val controller = UserControllerImpl(orderRepository = repository, errorHandler = ExceptionHandlerImpl())
//            print("5")
//            call.respond(controller.createUser(customer))
        }
    }
}