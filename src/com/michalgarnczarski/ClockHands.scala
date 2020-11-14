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

  // to refactor
  def printHand(x: Int, y: Int, slope: Double): Boolean = {
    if (slope == 0)
      if (x > 0 && Math.abs(y) < 2)
        true
      else false
    else if (slope > 0 && slope < Pi /2)
      if (!(x < 0 && y < 0) && pointLineDistance(x, y, slope) < 2)
        true
      else false
    else if (slope == Pi / 2)
      if (y > 0 && Math.abs(x) < 2)
        true
      else false
    else if (slope > Pi / 2 && slope < Pi)
      if (!(x > 0 && y < 0) && pointLineDistance(x, y, slope) < 2)
        true
      else false
    else if (slope == Pi)
      if (x < 0 && Math.abs(y) < 2)
        true
      else false
    else if (slope > Pi && slope < 3 * Pi / 2)
      if (!(x > 0 && y > 0) && pointLineDistance(x, y, slope) < 2)
        true
      else false
    else if (slope == 3 * Pi / 2)
      if (y < 0 && Math.abs(x) < 2)
        true
      else false
    else if (slope > 3 * Pi / 2 && slope < 2 * Pi)
      if (!(x < 0 && y > 0) && pointLineDistance(x, y, slope) < 2)
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
