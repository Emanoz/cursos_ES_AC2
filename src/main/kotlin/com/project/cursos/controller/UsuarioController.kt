package com.project.cursos.controller

import com.project.cursos.controller.dto.UsuarioDto
import com.project.cursos.controller.form.UsuarioForm
import com.project.cursos.modelo.Usuario
import com.project.cursos.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@CrossOrigin
@RequestMapping("/usuarios")
class UsuarioController {
    @Autowired
    private val usuarioRepository: UsuarioRepository? = null
    @GetMapping
    fun lista(): List<UsuarioDto> {
        val usuarios: List<Usuario> = usuarioRepository?.findAll() as List<Usuario>
        return UsuarioDto.converter(usuarios)
    }

    @PostMapping
    fun cadastrar(@RequestBody form: UsuarioForm, uriBuilder: UriComponentsBuilder): ResponseEntity<UsuarioDto> {
        val usuario: Usuario = form.converter(usuarioRepository)
        usuarioRepository?.save(usuario)
        val uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.id).toUri()
        return ResponseEntity.created(uri).body<UsuarioDto>(UsuarioDto(usuario))
    }
}