package com.michalgarnczarski

import scala.swing._
import java.awt.{Color, Graphics2D}

import scala.util.Random

class Canvas extends Panel {
  var centerColor = Color.yellow

  val colors = List(new Color(225, 221, 153),
    new Color(255, 212, 128),
    new Color(255, 204, 102),
    new Color(255, 230, 102),
    new Color(255, 212, 128),
    new Color(255, 179, 25)
    )

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

    val list = PointsCloud(100,10000)

    list.foreach(x => {
      g.setColor(colors(Random.nextInt(colors.length - 1)))
      g.drawOval(x._1 + 150, x._2 + 150, 1, 1)
    })



//    g.drawOval(0,0,1,1)

  }


}