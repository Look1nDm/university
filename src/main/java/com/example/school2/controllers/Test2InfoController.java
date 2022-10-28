package com.example.school2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Profile("second")
public class Test2InfoController {
    @Value("${server.port}")
    private final Integer port;

    @GetMapping
    public Integer getPort(){
        return port;
    }
}
