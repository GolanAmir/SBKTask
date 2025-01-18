package com.SBKAssignment.sbk

import org.springframework.web.multipart.MultipartFile
import org.springframework.ui.Model
import java.time.LocalDate

class fileParse{
    companion object{
        fun parseCSV(file : MultipartFile): MutableList<Triple<Int, LocalDate, Double>>{
            var readings : MutableList<Triple<Int, LocalDate, Double>> = mutableListOf()
            file.inputStream.bufferedReader().use { reader ->
                reader.lineSequence().forEach { line ->
                    val parts = line.split(",")
                    readings.add(Triple(parts[0].toInt(),LocalDate.parse(parts[1]),parts[2].toDouble()))
                }
            }
            
            return readings
        }
    }
}