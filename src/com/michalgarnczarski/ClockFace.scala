package com.michalgarnczarski

import scala.swing._
import java.awt.{Color, Graphics2D}

import scala.util.Random

class ClockFace(radius: Int, pointsNumber: Int) extends Panel {

  val faceColor = new Color(253, 217, 118)

  override def paintComponent(g: Graphics2D) {

    // Start by erasing this Canvas
    g.clearRect(0, 0, size.width, size.height)

//    // Draw background here
//    g.setColor(Color.blue)
//    g.fillOval(0, 0, 100, 100)
//    g.setColor(Color.red)
//    g.fillOval(20, 20, 60, 60)
//    g.setColor(centerColor)
//    g.fillOval(40, 40, 20, 20)

    val list = PointsCloud(radius, pointsNumber)

    list.foreach(x => {
      if (x._1 * x._1 + x._2 * x._2 > 95 * 95) g.setColor(Color.RED)
      else if (MarkerPrinter.printMainMarkers(radius, x._1, -x._2, 20, 5)) g.setColor(Color.RED)
      else if (MarkerPrinter.printExtraMarkers(radius, x._1, -x._2, 20, 2)) g.setColor(Color.RED)
      else if (ClockHandPrinter.printHandPoint(x._1, -x._2, ClockHands.secondsHandSlopeDiscrete, 80, 6)) g.setColor(Color.BLUE)
      else if (ClockHandPrinter.printHandPoint(x._1, -x._2, ClockHands.minutesHandSlope, 70, 6)) g.setColor(Color.BLUE)
      else if (ClockHandPrinter.printHandPoint(x._1, -x._2, ClockHands.hoursHandSlope, 50, 6)) g.setColor(Color.BLUE)
      else g.setColor(faceColor)
      g.drawOval(x._1 + 150, x._2 + 150, 1, 1)
    })
  }
}
