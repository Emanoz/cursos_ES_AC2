package com.project.cursos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Controller
@SpringBootApplication
@EnableSwagger2
class CursosApplication {

	fun main(args: Array<String>) {
		runApplication<CursosApplication>(*args)

		@RequestMapping("/")
		@ResponseBody
		fun home(): String? {
			return "index.html"
		}
	}
}
