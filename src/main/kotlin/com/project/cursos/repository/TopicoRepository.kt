package com.project.cursos.repository

import com.project.cursos.modelo.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository : JpaRepository<Topico, Long?> {
    fun findByCursoNome(nomeCurso: String?): List<Topico>
}