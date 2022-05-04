package com.project.cursos.repository

import com.project.cursos.modelo.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario?, Long?>