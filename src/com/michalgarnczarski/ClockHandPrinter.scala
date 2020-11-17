package com.michalgarnczarski

import scala.math.{Pi, abs, tan, sqrt}

object ClockHandPrinter {

  def printHandPoint(x: Int, y: Int, slope: Double, length: Int, thickness: Int): Boolean = {
    val inLength: Boolean = x * x + y * y < length * length
    val inThickness: Boolean = {
      val a: Double = if (slope == 0.5 * Pi || slope == 1.5 * Pi) 0 else tan(slope)
      abs(a * x - y) / sqrt(a * a + 1) < 0.5 * thickness
    }

    if (inThickness && inLength && (
        (slope == 0 && x >= 0) ||
        (slope > 0 && slope < 0.5 * Pi && y >= -x / tan(slope)) ||
        (slope == 0.5 * Pi && y >= 0) ||
        (slope > 0.5 * Pi && slope < Pi && y >= -x / tan(slope)) ||
        (slope == Pi && x <= 0) ||
        (slope > Pi && slope < 1.5 * Pi && y <= -x / tan(slope)) ||
        (slope == 1.5 * Pi && y < 0) ||
        (slope > 1.5 * Pi && slope < 2 * Pi && y <= -x / tan(slope)) ||
        (slope == 2 * Pi && x >= 0))) true else false
  }
}
