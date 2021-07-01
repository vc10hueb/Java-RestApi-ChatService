package com.example.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/example")
@Api(tags = "Example Api")
public class ExampleResource {

    @GetMapping
    @ApiOperation("Example rest end point that returns 'Hello World!'")
    public String getHelloWorld() {
        return "Hello World!";
    }

}
