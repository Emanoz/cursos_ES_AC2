package com.project.cursos.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorld {
    @RequestMapping("/")
    @ResponseBody
    fun hello(): String {
        return "Hello World!"
    }
}