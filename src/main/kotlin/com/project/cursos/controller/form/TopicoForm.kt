package com.project.cursos.controller.form

import com.project.cursos.modelo.Curso
import com.project.cursos.modelo.Topico
import com.project.cursos.repository.CursoRepository

class TopicoForm {
    var titulo: String? = null
    var mensagem: String? = null
    var nomeCurso: String? = null

    fun converter(cursoRepository: CursoRepository): Topico {
        val curso: Curso? = cursoRepository.findByNome(nomeCurso)
        return Topico(titulo, mensagem, curso)
    }
}