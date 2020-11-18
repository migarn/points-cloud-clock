package com.michalgarnczarski

import scala.swing._
import java.awt.{Color, Graphics2D}

class ClockFace(radius: Int, pointsNumber: Int) extends Panel {

  // Class printing points-cloud-based clock face.

  val faceColor: Color = new Color(253, 217, 118)
  val frameColor: Color = Color.RED
  val handsColor: Color = Color.BLUE

  override def paintComponent(graphic: Graphics2D) {
    graphic.clearRect(0, 0, size.width, size.height)
    val pointsCloud = PointsCloud(radius, pointsNumber)

    pointsCloud.foreach(point => {
      if ((point._1 * point._1 + point._2 * point._2 > 0.9 * (radius * radius)) ||
          MarkerPrinter.printMainMarkers(radius, point._1, -point._2, (0.2 * radius).toInt, 6) ||
          MarkerPrinter.printExtraMarkers(radius, point._1, -point._2, (0.15 * radius).toInt, 3))
        graphic.setColor(frameColor)
      else if (ClockHandPrinter.printHandPoint(point._1, -point._2, ClockHands.secondsHandSlopeDiscrete, (0.8 * radius).toInt, 6) ||
          ClockHandPrinter.printHandPoint(point._1, -point._2, ClockHands.minutesHandSlope, 70, 6) ||
          ClockHandPrinter.printHandPoint(point._1, -point._2, ClockHands.hoursHandSlope, 50, 6))
        graphic.setColor(handsColor)
      else
        graphic.setColor(faceColor)
      graphic.drawOval(point._1 + 150, point._2 + 150, 1, 1)
    })
  }
}
