package com.project.cursos.controller.dto

import com.project.cursos.modelo.Usuario
import java.util.function.Function
import java.util.stream.Collectors

class UsuarioDto(usuario: Usuario) {
    val id: Long
    val nome: String
    val email: String
    val senha: String

    init {
        id = usuario.id!!
        nome = usuario.nome!!
        email = usuario.email!!
        senha = usuario.senha!!
    }

    companion object {
        fun converter(usuarios: List<Usuario>): List<UsuarioDto> {
            return usuarios.stream().map(Function<Usuario, UsuarioDto> { usuario: Usuario ->
                UsuarioDto(
                    usuario
                )
            }).collect(Collectors.toList())
        }
    }
}
