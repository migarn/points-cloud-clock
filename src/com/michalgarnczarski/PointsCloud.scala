package com.michalgarnczarski

import scala.util.Random

object PointsCloud {

  def apply(radius: Int, pointsNumber: Int): List[(Int, Int)] = {

    def generatePoint(): (Int, Int) = {
      val x: Int = Random.nextInt(2 * radius) - radius
      val y: Int = Random.nextInt(2 * radius) - radius
      if (x * x + y * y <= radius * radius) (x, y)
      else generatePoint()
    }

    List.fill(pointsNumber)(generatePoint())
  }
}
