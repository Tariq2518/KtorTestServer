package com.tariq

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

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
    routing {
        get("/second"){
            call.respondText("Hello from Second World")
        }
    }
}


