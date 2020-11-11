package com.michalgarnczarski

import scala.swing._
import java.awt.Font.BOLD

object Main extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "Hello"
    preferredSize = new Dimension(300, 200)

    contents = new Label {
      text = "Hello!"
      font = new Font("Arial", BOLD, 24)
      resizable = false
    }

    peer.setLocationRelativeTo(null)
  }
}
