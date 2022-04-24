package com.project.cursos.controller.dto

import com.project.cursos.modelo.Topico
import java.time.LocalDateTime
import java.util.function.Function
import java.util.stream.Collectors

class TopicoDto {

    companion object {
        fun converter(topicos: List<Topico>): List<TopicoDto> {
            return topicos.stream().map(Function<Topico, TopicoDto> { topico: Topico -> TopicoDto(topico) })
                .collect(Collectors.toList())
        }
    }

    var id: Long? = null
        private set
    var titulo: String? = null
        private set
    var mensagem: String? = null
        private set
    var dataCriacao: LocalDateTime? = null
        private set

    constructor(topico: Topico) {
        id = topico.id
        titulo = topico.titulo
        mensagem = topico.mensagem
        dataCriacao = topico.dataCriacao
    }
}
