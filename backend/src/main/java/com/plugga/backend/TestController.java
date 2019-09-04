package com.plugga.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public final class TestController {

    @GetMapping
    public final String test() throws UnknownHostException {
        return "Hello from TestController!!!! My address is " + InetAddress.getLocalHost().getHostAddress();
    }
}