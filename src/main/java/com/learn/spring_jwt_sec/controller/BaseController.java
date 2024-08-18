package com.learn.spring_jwt_sec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BaseController {

    @GetMapping("/info")
    public String info() {
        return "this is jwt learn project";
    }

    @GetMapping("/user")
    public String user() {
        return "this is user api";
    }

    @GetMapping("/admin")
    public String admin() {
        return "this is admin api";
    }

}
