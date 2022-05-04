package com.project.cursos.repository

import com.project.cursos.modelo.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository : JpaRepository<Curso?, Long?> {
    fun findByNome(nome: String?): Curso?
}