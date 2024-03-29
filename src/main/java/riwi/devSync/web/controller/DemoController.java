package riwi.devSync.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DemoController {
    @PostMapping("/demo")
    public String demo() {
        return "Welcome to this endpoint!";
    }

    @GetMapping("/test")
    public String test() {
        return "This is a test without token";
    }
}
