package com.michalgarnczarski

import scala.math.Pi

object MarkerPrinter {

  // Functions determine if a point belongs to given clock face markers

  def printMainMarkers(radius: Int, x: Int, y: Int, length: Int, thickness: Int): Boolean = {
    val twelveOClock: Boolean = ClockHandPrinter.printHandPoint(x, y, 0.5 * Pi, radius, thickness)
    val threeOClock: Boolean = ClockHandPrinter.printHandPoint(x, y, 0, radius, thickness)
    val sixOClock: Boolean = ClockHandPrinter.printHandPoint(x, y, 1.5 * Pi, radius, thickness)
    val nineOClock: Boolean = ClockHandPrinter.printHandPoint(x, y, Pi, radius, thickness)

    if (inLength(radius, x, y, length) && (twelveOClock || threeOClock || sixOClock || nineOClock)) true
    else false
  }

  def printExtraMarkers(radius: Int, x: Int, y: Int, length: Int, thickness: Int): Boolean = {
    val oneOClock: Boolean = ClockHandPrinter.printHandPoint(x, y, Pi / 6, radius, thickness)
    val twoOClock: Boolean = ClockHandPrinter.printHandPoint(x, y, Pi / 3, radius, thickness)
    val fourOClock: Boolean = ClockHandPrinter.printHandPoint(x, y, 2 * Pi / 3, radius, thickness)
    val fiveOClock: Boolean = ClockHandPrinter.printHandPoint(x, y, 5 * Pi / 6, radius, thickness)
    val sevenOClock: Boolean = ClockHandPrinter.printHandPoint(x, y, 7 * Pi / 6, radius, thickness)
    val eightOClock: Boolean = ClockHandPrinter.printHandPoint(x, y, 4 * Pi / 3, radius, thickness)
    val tenOClock: Boolean = ClockHandPrinter.printHandPoint(x, y, 5 * Pi / 3, radius, thickness)
    val elevenOClock: Boolean = ClockHandPrinter.printHandPoint(x, y, 11 * Pi / 6, radius, thickness)

    if (inLength(radius, x, y, length) &&
       (oneOClock || twoOClock || fourOClock || fiveOClock || sevenOClock || eightOClock || tenOClock || elevenOClock))
      true
    else false
  }

  private def inLength(radius: Int, x: Int, y: Int, length: Int): Boolean =
    x * x + y * y > (radius - length) * (radius - length)
}
