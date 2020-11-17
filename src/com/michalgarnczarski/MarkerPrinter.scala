package com.michalgarnczarski

import scala.math.{Pi, abs, tan, sqrt}

object MarkerPrinter {

  // Functions determine if a point belongs to given clock face markers

  def printMainMarkers(radius: Int, x: Int, y: Int, length: Int, thickness: Int): Boolean = {

    val hand12: Boolean = ClockHandPrinter.printHandPoint(x, y, 0.5 * Pi, radius, thickness)
    val hand3: Boolean = ClockHandPrinter.printHandPoint(x, y, 0, radius, thickness)
    val hand6: Boolean = ClockHandPrinter.printHandPoint(x, y, 1.5 * Pi, radius, thickness)
    val hand9: Boolean = ClockHandPrinter.printHandPoint(x, y, Pi, radius, thickness)

    if (inLength(radius, x, y, length) && (hand12 || hand3 || hand6 || hand9)) true
    else false



//    val inLengthInner: Boolean = inLength(radius, x, y, length)
//
//    if (inLengthInner && (inThickness(0, x, y, thickness) || inThickness(0.4 * Pi, x, y, thickness)))
//      true
//    else false


  }

//  def printExtraMarkers(radius: Int, x: Int, y: Int, length: Int, thickness: Int): Boolean = {
//    val inLength: Boolean = inLength(radius, x, y, length)
//
//  }

  private def inLength(radius: Int, x: Int, y: Int, length: Int): Boolean =
    x * x + y * y > (radius - length) * (radius - length)

  private def inThickness(slope: Double, x: Int, y: Int, thickness: Int): Boolean = {
    val a: Double = if (slope == 0.5 * Pi || slope == 1.5 * Pi) 0 else tan(slope)
    abs(a * x - y) / sqrt(a * a + 1) < 0.5 * thickness
  }

}
