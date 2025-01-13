package com.assignment.sbk.controllersTest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.SessionAttributes
import org.springframework.stereotype.Controller
import org.springframework.ui.Model

@Controller
@SessionAttributes("names")
class sbkWebAppHello {
	@GetMapping("/")
	fun htmlGreet (model: Model) : String {
		return "testhtml"
	}
}