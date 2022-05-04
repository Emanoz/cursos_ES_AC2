package com.project.cursos.controller.form

import com.project.cursos.modelo.Usuario
import com.project.cursos.repository.UsuarioRepository

class UsuarioForm {
    var nome: String? = null
    var email: String? = null
    var senha: String? = null

    fun converter(usuarioRepository: UsuarioRepository?): Usuario {
        return Usuario(nome, email, senha)
    }
}