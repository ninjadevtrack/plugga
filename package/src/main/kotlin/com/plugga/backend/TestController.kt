package com.plugga.backend

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

import java.net.InetAddress
import java.net.UnknownHostException

@RestController
class TestController {

    @GetMapping("/")
    @Throws(UnknownHostException::class)
    fun test(): String {
        return "Hello from TestController!!!! My address is " + InetAddress.getLocalHost().hostAddress
    }
}