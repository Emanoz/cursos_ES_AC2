package com.project.cursos

import com.project.cursos.controller.HelloWorld
import com.project.cursos.controller.UsuarioController
import com.project.cursos.controller.dto.UsuarioDto
import com.project.cursos.modelo.Usuario
import junit.framework.TestCase.assertEquals
import org.aspectj.weaver.IntMap
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringRunner::class) //@SpringBootTest
@WebMvcTest(controllers = [HelloWorld::class])

class CursosApplicationTests {
	@Autowired
	private val mockMvc: MockMvc? = null

	@Autowired
	private val controllerUser: UsuarioController? = null
	@Test
	@Throws(Exception::class)
	fun testHelloWorld() {
		mockMvc
			?.perform(MockMvcRequestBuilders.get("/hello"))
			?.andExpect(MockMvcResultMatchers.status().isOk)
			?.andExpect(MockMvcResultMatchers.content().string("Hello World!"))
	}

	@Test
	@Throws(Exception::class)
	fun testListLogin() {
		val user = Usuario(nome = "Emanuel", email = "emanuel@hotmail.com", senha = "123456", id = 3)
		val userDto = UsuarioDto(usuario = user)

		mockMvc
			?.perform(MockMvcRequestBuilders.get("/usuarios"))
			?.andExpect(MockMvcResultMatchers.status().is4xxClientError)

		val response = controllerUser?.lista()
		assertEquals(response?.get(2)?.nome ?: UsuarioDto(user).nome, userDto.nome)
	}
}
