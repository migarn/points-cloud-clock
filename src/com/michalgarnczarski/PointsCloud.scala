package com.michalgarnczarski

import scala.util.Random
import scala.math.{cos, sin, Pi}

object PointsCloud {

  def apply(radius: Int, pointsNumber: Int): List[(Int, Int)] = {

    def generatePoint(): (Int, Int) = {
      val tempRadius: Int = Random.nextInt(radius)
      val angle: Double = Random.nextDouble() * 2 * Pi
      ((tempRadius * cos(angle)).round.toInt, (tempRadius * sin(angle)).round.toInt)
    }

    List.fill(pointsNumber)(generatePoint())
  }
}
