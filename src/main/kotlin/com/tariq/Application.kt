package com.tariq

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.events.EventDefinition
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.*
import io.ktor.util.logging.*
import io.ktor.util.pipeline.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module(){

    routing {
        get("/"){
            call.respondText("Hello World")
        }
    }
}

@Suppress("unused")
fun Application.module2(){
    install(CallLogging)
    routing {
        get("/second"){
            call.respondText("Hello from Second World")
        }
    }
}


