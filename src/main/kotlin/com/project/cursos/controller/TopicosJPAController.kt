package com.project.cursos.controller

import com.project.cursos.controller.dto.TopicoDto
import com.project.cursos.controller.form.TopicoForm
import com.project.cursos.modelo.Topico
import com.project.cursos.repository.CursoRepository
import com.project.cursos.repository.TopicoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topicos")
class TopicosJPAController {
    @Autowired
    private val topicoRepository: TopicoRepository? = null

    @Autowired
    private val cursoRepository: CursoRepository? = null
    @GetMapping
    fun lista(nomeCurso: String?): List<TopicoDto> {
        return if (nomeCurso == null) {
            val topicos = topicoRepository!!.findAll()
            TopicoDto.converter(topicos)
        } else {
            val topicos = topicoRepository!!.findByCursoNome(nomeCurso)
            TopicoDto.converter(topicos)
        }
    }

    @PostMapping
    fun cadastrar(@RequestBody form: TopicoForm, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoDto> {
        val topico: Topico = form.converter(cursoRepository!!)
        topicoRepository!!.save(topico)
        val uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.id).toUri()
        return ResponseEntity.created(uri).body(TopicoDto(topico))
    }
}