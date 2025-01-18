package com.SBKAssignment.sbk

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import com.SBKAssignment.sbk.Reading
import java.time.LocalDate

@Repository
interface ReadingRepository : JpaRepository<Reading, Long> {

    @Query("SELECT r FROM Reading r " + "WHERE r.meterId = :meterId AND r.readingDate <= :currentDate " + "ORDER BY r.readingDate DESC")

    fun findLastReadingBeforeDate(@Param("meterId") meterId: Int, @Param("currentDate") currentDate: LocalDate): List<Reading>
}