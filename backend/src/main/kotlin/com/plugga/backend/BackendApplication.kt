package com.plugga.backend

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BackendApplication {

//    @JvmStatic
    fun main(args: Array<String>) {
//        SpringApplication.run(BackendApplication::class.java, *args)
        runApplication<BackendApplication>(*args)
    }
}
