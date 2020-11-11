package com.michalgarnczarski

import scala.swing._
import java.awt.Font.BOLD

object Main extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "Hello"
    preferredSize = new Dimension(300, 200)

    val canvas = new Canvas {
      preferredSize = new Dimension(100, 100)
    }

    contents = canvas

    peer.setLocationRelativeTo(null)
  }
}
