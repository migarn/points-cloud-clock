package com.michalgarnczarski

import scala.util.Random
import scala.math.{cos, sin, Pi}

object PointsCloud {

  def apply(radius: Int, pointsNumber: Int): List[(Int, Int)] = {

    def generatePoint(): (Int, Int) = {
      val angle: Double = Random.nextDouble() * 2 * Pi
      ((radius * cos(angle)).round.toInt, (radius * sin(angle)).round.toInt)
    }

    List.fill(pointsNumber)(generatePoint())
  }
}
