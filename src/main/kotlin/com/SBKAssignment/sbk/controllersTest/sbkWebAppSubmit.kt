package com.assignment.sbk.controllersTest

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.SessionAttributes

@Controller
@SessionAttributes("names")
class sbkWebAppSubmit {
	@PostMapping("/submit")
	fun submitTo (@RequestParam inputField : String, model : Model) : String {
		val names = model.asMap()["names"] as? MutableList<String> ?: mutableListOf()
		names.add(inputField)
		model.addAttribute("names", names)
		return "redirect:/"
	}
}