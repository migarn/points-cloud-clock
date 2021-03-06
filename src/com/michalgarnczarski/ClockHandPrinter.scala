package com.michalgarnczarski

import scala.math.{Pi, abs, tan, sqrt}

object ClockHandPrinter {

  // Function determines if a point belongs to given clock hand

  def printHandPoint(x: Int, y: Int, slope: Double, length: Int, thickness: Int): Boolean = {
    val inLength: Boolean = x * x + y * y < length * length
    val inThickness: Boolean = {
      if (slope == 0.5 * Pi || slope == 1.5 * Pi)
        abs(x) < 0.5 * thickness
      else {
        val a: Double = tan(slope)
        abs(a * x - y) / sqrt(a * a + 1) < 0.5 * thickness
      }
    }

    if (inThickness && inLength && (
       (slope == 0 && x >= 0) ||
       (slope > 0 && slope < 0.5 * Pi && y >= -x / tan(slope)) ||
       (slope == 0.5 * Pi && y >= 0) ||
       (slope > 0.5 * Pi && slope < Pi && y >= -x / tan(slope)) ||
       (slope == Pi && x <= 0) ||
       (slope > Pi && slope < 1.5 * Pi && y <= -x / tan(slope)) ||
       (slope == 1.5 * Pi && y < 0) ||
       (slope > 1.5 * Pi && slope < 2 * Pi && y <= -x / tan(slope))))
      true
    else false
  }
}
