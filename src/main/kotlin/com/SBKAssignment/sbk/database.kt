package com.SBKAssignment.sbk

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import java.time.LocalDate
import org.springframework.data.jpa.repository.JpaRepository

@Entity
data class Consumption(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val meterId: Int,

    val currentReadingDate: LocalDate,

    val lastReadingDate: LocalDate,

    val consumption: Double
)

@Entity
data class Reading(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val meterId: Int,

    val readingDate: LocalDate,

    val rawValue: Double
)