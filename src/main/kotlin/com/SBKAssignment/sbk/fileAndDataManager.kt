package com.SBKAssignment.sbk

import org.springframework.web.multipart.MultipartFile
import java.time.LocalDate

class fileAndDataManager(){
    companion object{
        fun manage(filesWithFormats: List<Pair<MultipartFile,String>>, dbHandle: databaseHandle){
            for ((file, format) in filesWithFormats){
                println("Sends files to correct parser by format.\nOnly handles CSV, other formats return empty list causing no trouble.")
                var readings = sortToParseByFormat(file, format)
                println("Number of readings in file: ${readings.size}")
                for (reading in readings){
                    val currentNormalizedValue = dataCalc.normalizeToCubicM(reading.first, reading.third)
                    val previousReading = dbHandle.getPreviousMeterReading(reading)
                    val previousNormalizedValue = dataCalc.normalizeToCubicM(previousReading.first, previousReading.third)
                    val consumption = dataCalc.consumption(currentNormalizedValue, previousNormalizedValue)
                    dbHandle.addReading(reading)
                    dbHandle.addConsumption(reading, previousReading.second, consumption)
                }
            }
        }

        fun sortToParseByFormat(file: MultipartFile, format: String): MutableList<Triple<Int, LocalDate, Double>>{
            var emptyList: MutableList<Triple<Int, LocalDate, Double>> = mutableListOf()
            if(format == "CSV"){
                return fileParse.parseCSV(file)
            }else if(format == "xls"){
                return emptyList
            }else if(format == "html"){
                return emptyList
            }
            return emptyList
        }
    }
    
}