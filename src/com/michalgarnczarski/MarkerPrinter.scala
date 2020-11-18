package com.michalgarnczarski

import scala.math.{Pi, abs, tan, sqrt}

object MarkerPrinter {

  // Functions determine if a point belongs to given clock face markers


  // to refactor
  def printMainMarkers(radius: Int, x: Int, y: Int, length: Int, thickness: Int): Boolean = {

    val hand12: Boolean = ClockHandPrinter.printHandPoint(x, y, 0.5 * Pi, radius, thickness)
    val hand3: Boolean = ClockHandPrinter.printHandPoint(x, y, 0, radius, thickness)
    val hand6: Boolean = ClockHandPrinter.printHandPoint(x, y, 1.5 * Pi, radius, thickness)
    val hand9: Boolean = ClockHandPrinter.printHandPoint(x, y, Pi, radius, thickness)

    if (inLength(radius, x, y, length) && (hand12 || hand3 || hand6 || hand9)) true
    else false
  }

  def printExtraMarkers(radius: Int, x: Int, y: Int, length: Int, thickness: Int): Boolean = {
    val hand1: Boolean = ClockHandPrinter.printHandPoint(x, y, Pi / 6, radius, thickness)
    val hand2: Boolean = ClockHandPrinter.printHandPoint(x, y, Pi / 3, radius, thickness)
    val hand4: Boolean = ClockHandPrinter.printHandPoint(x, y, 2 * Pi / 3, radius, thickness)
    val hand5: Boolean = ClockHandPrinter.printHandPoint(x, y, 5 * Pi / 6, radius, thickness)
    val hand7: Boolean = ClockHandPrinter.printHandPoint(x, y, 7 * Pi / 6, radius, thickness)
    val hand8: Boolean = ClockHandPrinter.printHandPoint(x, y, 4 * Pi / 3, radius, thickness)
    val hand10: Boolean = ClockHandPrinter.printHandPoint(x, y, 5 * Pi / 3, radius, thickness)
    val hand11: Boolean = ClockHandPrinter.printHandPoint(x, y, 11 * Pi / 6, radius, thickness)

    if (inLength(radius, x, y, length) && (hand1 || hand2 || hand4 || hand5 || hand7 || hand8 || hand10 || hand11)) true
    else false

  }

  private def inLength(radius: Int, x: Int, y: Int, length: Int): Boolean =
    x * x + y * y > (radius - length) * (radius - length)
}
