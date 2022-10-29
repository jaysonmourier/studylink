package com.miageapp.studylink_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class TestController {
    public TestController() {}
    
    @GetMapping("/test")
    public String test() { return "Ready to Go !"; }
}
