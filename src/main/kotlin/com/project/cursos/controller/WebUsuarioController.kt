package com.project.cursos.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/webUsuario")
class WebUsuarioController {
    @get:GetMapping
    val formularioParaUsuarios: String
        get() = "webUsuario/home"
}