package com.SBKAssignment.sbk

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.SessionAttributes
import org.springframework.web.multipart.MultipartFile
import org.springframework.ui.Model

@Controller
@SessionAttributes("files")
class fileRequestandFormatPage(val dbHandle: databaseHandle) {

	var files : MutableList<MultipartFile> = mutableListOf()

	@GetMapping("/")
	fun welcome (model: Model) : String {
		return "htmlFiles/requestFormat"
	}

	@PostMapping("/submit")
	fun uploadFiles (@RequestParam uploadedFiles : List<MultipartFile>, @RequestParam formats : List<String>, model : Model) : String {
		val filesWithFormats = uploadedFiles.mapIndexed { index, file ->
			Pair(file, formats[index])
		}
		model.addAttribute("filesWithFormats", filesWithFormats)

		println("Uploaded Files and Formats:")
		for ((file, format) in filesWithFormats){
			println("File: ${file.originalFilename}, Format: $format")
		} 
		fileAndDataManager.manage(filesWithFormats, dbHandle)
		
		return "redirect:/h2-console"
	}
}