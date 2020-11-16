package com.michalgarnczarski

import java.util.Calendar
import scala.math.Pi

object ClockHands {

  def secondsHandSlopeDiscrete: Double = {
    val currentSeconds: Int = Calendar.getInstance().get(Calendar.SECOND)
    if (currentSeconds < 15)
      currentSeconds * (-Pi / 30) + Pi / 2
    else
      currentSeconds * (-Pi / 30) + 5 * Pi / 2
  }

  def secondsHandSlopeContinuous: Double = {
    val currentSeconds: Int = Calendar.getInstance().get(Calendar.SECOND)
    val currentMilliseconds: Int = Calendar.getInstance().get(Calendar.MILLISECOND)
    val millisecondInMinute: Int = currentSeconds * 1000 + currentMilliseconds
    if (millisecondInMinute < 15000)
      millisecondInMinute * (-Pi / 30000) + Pi / 2
    else
      millisecondInMinute * (-Pi / 30000) + 5 * Pi / 2
  }

  def minutesHandSlope: Double = {
    val currentMinutes: Int = Calendar.getInstance().get(Calendar.MINUTE)
    val currentSeconds: Int = Calendar.getInstance().get(Calendar.SECOND)
    val secondInHour: Int = currentMinutes * 60 + currentSeconds
    if (secondInHour < 900)
      secondInHour * (-Pi / 1800) + Pi / 2
    else
      secondInHour * (-Pi / 1800) + 5 * Pi / 2
  }

  def hoursHandSlope: Double = {
    val currentHours: Int = Calendar.getInstance().get(Calendar.HOUR)
    val currentMinutes: Int = Calendar.getInstance().get(Calendar.MINUTE)
    val minuteInHour: Int = currentHours * 60 + currentMinutes
    if (minuteInHour < 180)
      minuteInHour * (-Pi / 360) + Pi / 2
    else
      minuteInHour * (-Pi / 360) + 5 * Pi / 2
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
