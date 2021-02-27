package com.example.keanchin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class HomeController {

    @ApiIgnore
    @GetMapping("/")
    public String home() {
        return "API is Up";
    }
}
