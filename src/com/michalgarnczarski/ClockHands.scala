package com.michalgarnczarski

import java.util.Calendar
import scala.math.Pi

object ClockHands {

  // The functions below calculate slope of clock hands based on a system clock.

  def secondsHandSlopeDiscrete: Double = {
    val currentSeconds: Int = Calendar.getInstance().get(Calendar.SECOND)
    calculateSlope(60, currentSeconds)
  }

  def secondsHandSlopeContinuous: Double = {
    val currentSeconds: Int = Calendar.getInstance().get(Calendar.SECOND)
    val currentMilliseconds: Int = Calendar.getInstance().get(Calendar.MILLISECOND)
    val currentMillisecondsInMinute: Int = currentSeconds * 1000 + currentMilliseconds
    calculateSlope(60000, currentMillisecondsInMinute)
  }

  def minutesHandSlope: Double = {
    val currentMinutes: Int = Calendar.getInstance().get(Calendar.MINUTE)
    val currentSeconds: Int = Calendar.getInstance().get(Calendar.SECOND)
    val currentSecondsInHour: Int = currentMinutes * 60 + currentSeconds
    calculateSlope(3600, currentSecondsInHour)
  }

  def hoursHandSlope: Double = {
    val currentHours: Int = Calendar.getInstance().get(Calendar.HOUR)
    val currentMinutes: Int = Calendar.getInstance().get(Calendar.MINUTE)
    val currentMinutesIn12Hours: Int = currentHours * 60 + currentMinutes
    calculateSlope(720, currentMinutesIn12Hours)
  }

  // Function calculates slope of a line. For 2nd, 3rd and 4th quarter 2 Pi is added to avoid negative value.

  private def calculateSlope(unitsPerCircle: Int, currentValue: Int): Double = {
    if (currentValue < 0.25 * unitsPerCircle)
      -(2 * Pi / unitsPerCircle) * currentValue + 0.5 * Pi
    else
      -(2 * Pi / unitsPerCircle) * currentValue + 2.5 * Pi
  }
}
