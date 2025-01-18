package com.SBKAssignment.sbk

import org.springframework.data.jpa.repository.JpaRepository
import com.SBKAssignment.sbk.Consumption

interface ConsumptionRepository : JpaRepository<Consumption, Long>