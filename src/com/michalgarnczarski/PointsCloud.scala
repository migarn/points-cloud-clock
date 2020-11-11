package com.michalgarnczarski

import scala.util.Random
import scala.math.{cos, sin, Pi}

class PointsCloud {

  def apply(radius: Int, pointsNumber: Int): List[(Int, Int)] = {

    def generatePoint(): (Int, Int) =
      (radius * cos(Random.nextDouble() * 2 * Pi).round.toInt, radius * sin(Random.nextDouble() * 2 * Pi).round.toInt)

    null
  }

}
