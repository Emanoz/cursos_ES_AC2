package com.project.cursos

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Controller
@SpringBootApplication
@EnableSwagger2
class PraticandoApiApplication {
	@RequestMapping("/")
	@ResponseBody
	fun home(): String {
		return "index.html"
	}

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(PraticandoApiApplication::class.java, *args)
		}
	}
}

