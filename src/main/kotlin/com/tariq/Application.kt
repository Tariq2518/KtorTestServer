package com.tariq

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.events.EventDefinition
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.*
import io.ktor.util.logging.*
import io.ktor.util.pipeline.*
import kotlinx.html.*
import kotlinx.serialization.Serializable

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {

    install(CallLogging)
    install(ContentNegotiation){
        json()
    }
    routing {
        staticResources("/", "staticdata"){
            default("tariqdev.html")
        }
        get("/") {
            call.respondText("Hello World23")
        }

        get("/users1/{username}") {
            val username = call.parameters["username"]
            call.respondText("Good night! $username")
        }

        get("/users2/{username}") {
            val username = call.parameters["username"]
            val header = call.request.headers["Connection"]
            if (username == "Tariq") {
                call.response.header(name = "MyName", "Tariq")
                call.respond(message = "Hello Tariq How", status = HttpStatusCode.OK)
            }
            call.respondText("Good night! $username and please $header")
        }

        get("/user") {
            val username = call.request.queryParameters["name"]
            val age = call.request.queryParameters["age"]

            call.respondText("Good night! $username your age is $age")
        }

        get("/developer") {
            try {
                val developer = Developer(name = "Tariq", age = 24)
                call.respond(message = developer, status = HttpStatusCode.OK)
            } catch (e: Exception) {
                call.respond(message = "${e.message}", status = HttpStatusCode.BadRequest)
            }
        }

        get("/redirect") {
            call.respondRedirect("/developer", false)
        }

        get("/templating") {
            call.respondHtml{
                head {
                    title{+"Templating"}

                }
                body {
                    h1 {+"First html in kotlin"}
                    p {+"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel egestas dolor, nec dignissim metus. Donec augue elit, rhoncus ac sodales id, \n porttitor vitae est. Donec laoreet rutrum libero sed pharetra. \n Donec vel egestas dolor, nec dignissim metus. Donec augue elit, rhoncus ac sodales id, porttitor vitae est. Donec laoreet rutrum libero sed pharetra. \n Duis a arcu convallis, gravida purus eget, mollis diam."}

                }
            }
        }

    }
}


@Serializable
data class Developer(
    val name: String,
    val age: Int
)



