package com.michalgarnczarski

import scala.util.Random

object PointsCloud {

  // Object generates a disk-shaped cloud of single points.

  def apply(radius: Int, pointsNumber: Int): List[(Int, Int)] = {

    def generatePoint: (Int, Int) = {
      def generateCoordinate: Int = Random.nextInt(2 * radius) - radius
      val x: Int = generateCoordinate
      val y: Int = generateCoordinate
      if (x * x + y * y <= radius * radius) (x, y)
      else generatePoint
    }

    List.fill(pointsNumber)(generatePoint)
  }
}
