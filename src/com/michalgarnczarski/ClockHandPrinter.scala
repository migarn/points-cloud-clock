package com.michalgarnczarski

import scala.math.Pi

object ClockHandPrinter {

  def printHandPoint(x: Int, y: Int, slope: Double, faceRadius: Int, handFaceRatio: Double, thickness: Int): Boolean = {

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
