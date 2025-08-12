package io.everytech.everyapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform