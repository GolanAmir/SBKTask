package com.SBKAssignment.sbk

import java.time.LocalDate

class dataCalc{
	companion object{
		fun normalizeToCubicM(meterID: Int, value: Double) : Double{
			val meterUnits = unitMeters(meterID)
			if(meterUnits == "GALLON"){
				return value*0.003785
			}else if(meterUnits == "LITRE"){
				return value*0.001
			}else{
				return value
			}
		}

		fun unitMeters(meterID: Int) : String{
			if(meterID % 3 == 1){
				return "GALLON"
			}else if(meterID % 3 == 2){
				return "LITRE"
			}else{
				return "CUBIC_METER"
			}
		}
		
		fun consumption(currentNormalizedValue: Double, previousNormalizedValue: Double): Double{
			return currentNormalizedValue - previousNormalizedValue
		}
	}

}