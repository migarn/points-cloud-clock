package com.michalgarnczarski

import java.util.Calendar
import scala.math.Pi

object ClockHands {

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

  private def calculateSlope(unitsPerCircle: Int, currentValue: Int): Double = {
    if (currentValue < 0.25 * unitsPerCircle)
      -(2 * Pi / unitsPerCircle) * currentValue + 0.5 * Pi
    else
      -(2 * Pi / unitsPerCircle) * currentValue + 2.5 * Pi
  }

  // to refactor
  def printHand(x: Int, y: Int, slope: Double): Boolean = {
    if (slope == 0)
      if (x > 0 && Math.abs(y) < 2)
        true
      else false
    else if (slope > 0 && slope < Pi /2)
      if (y >= -x / Math.tan(slope) && pointLineDistance(x, y, slope) < 2)
        true
      else false
    else if (slope == Pi / 2)
      if (y > 0 && Math.abs(x) < 2)
        true
      else false
    else if (slope > Pi / 2 && slope < Pi)
      if (y >= -x / Math.tan(slope) && pointLineDistance(x, y, slope) < 2)
        true
      else false
    else if (slope == Pi)
      if (x < 0 && Math.abs(y) < 2)
        true
      else false
    else if (slope > Pi && slope < 3 * Pi / 2)
      if (y <= -x / Math.tan(slope) && pointLineDistance(x, y, slope) < 2)
        true
      else false
    else if (slope == 3 * Pi / 2)
      if (y < 0 && Math.abs(x) < 2)
        true
      else false
    else if (slope > 3 * Pi / 2 && slope < 2 * Pi)
      if (y <= -x / Math.tan(slope) && pointLineDistance(x, y, slope) < 2)
        true
      else false
    else if (slope == 2 * Pi)
      if (x > 0 && Math.abs(y) < 2)
        true
      else false
    else
      false
  }

  def pointLineDistance(x: Int, y: Int, slope: Double): Double = {
    Math.abs(Math.tan(slope) * x - y) / Math.sqrt(Math.tan(slope) * Math.tan(slope) + 1)
  }


}
