package com.project.cursos.controller

import com.project.cursos.controller.dto.TopicoDto
import com.project.cursos.modelo.Topico
import com.project.cursos.repository.TopicoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TopicosJPAController {
    @Autowired
    private val topicoRepository: TopicoRepository? = null

    @RequestMapping("/topicosJPA")
    fun lista(nomeCurso: String?): List<TopicoDto> {
        return if (nomeCurso == null) {
            val topicos: List<Topico> = topicoRepository!!.findAll()
            TopicoDto.converter(topicos)
        } else {
            val topicos: List<Topico> = topicoRepository!!.findByCursoNome(nomeCurso)
            TopicoDto.converter(topicos)
        }
    }
}