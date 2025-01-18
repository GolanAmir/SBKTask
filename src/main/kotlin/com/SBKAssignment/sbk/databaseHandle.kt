package com.SBKAssignment.sbk

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class databaseHandle(
	val readingRepository: ReadingRepository,
	val consumptionRepository: ConsumptionRepository
){
    fun addReading(reading: Triple<Int, LocalDate, Double>){
        readingRepository.save(
            Reading(
                meterId = reading.first,
                readingDate = reading.second,
                rawValue = reading.third
            )
        )
    }

    fun addConsumption(reading: Triple<Int, LocalDate, Double>, previousReadingDate: LocalDate, consumption: Double){
        consumptionRepository.save(
            Consumption(
                meterId = reading.first,
                currentReadingDate = reading.second,
                lastReadingDate = previousReadingDate,
                consumption = consumption
            )
        )
    }

    fun getPreviousMeterReading(currentReading: Triple<Int, LocalDate, Double>): Triple<Int, LocalDate, Double>{
        val readings = readingRepository.findLastReadingBeforeDate(currentReading.first, currentReading.second)

        if(readings == null || readings.size == 0){
            return Triple(currentReading.first, currentReading.second.minusDays(1), 0.0)
        }else{
            val lastReading = readings.first()
            return Triple(lastReading.meterId, lastReading.readingDate, lastReading.rawValue)
        }
    }
}