package com.plugga.backend

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
object BackendApplication {

    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(BackendApplication::class.java, *args)
    }

}
