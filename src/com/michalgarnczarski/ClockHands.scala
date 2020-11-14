package com.michalgarnczarski

import java.util.Calendar
import scala.math.Pi

object ClockHands {

  def secondsHandSlopeDiscrete: Double = {
    val currentSeconds: Int = Calendar.getInstance().get(Calendar.SECOND)
    currentSeconds * (-Pi / 30) + Pi / 2
  }



}
