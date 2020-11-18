package com.michalgarnczarski

import scala.swing._

object Main extends SimpleSwingApplication {

  def top = new MainFrame {
    title = "Hello"
    preferredSize = new Dimension(325, 325)

    val t = new java.util.Timer()
    val task = new java.util.TimerTask {
      def run() = {


        val canvas = new ClockFace(100, 20000) {
          preferredSize = new Dimension(100, 100)
        }

        contents = canvas


      }
    }
    t.schedule(task, 100L, 100L)
    task.run()



    peer.setLocationRelativeTo(null)
  }


}
