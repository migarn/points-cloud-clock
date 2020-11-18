package com.michalgarnczarski

import scala.swing._
import java.util.{Timer, TimerTask}

object Main extends SimpleSwingApplication {

  def top: MainFrame = new MainFrame {
    title = "Points Cloud Clock"
    preferredSize = new Dimension(240, 260)

    val timer: Timer = new Timer
    val task: TimerTask = new TimerTask {
      def run = {
        val clockFace: ClockFace = new ClockFace(100, 20000) {
          preferredSize = new Dimension(100, 100)
        }
        contents = clockFace
      }
    }
    timer.schedule(task, 0, 100L)
    task.run
    peer.setLocationRelativeTo(null)
  }


}
