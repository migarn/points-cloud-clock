package com.michalgarnczarski

import java.util.Calendar
import scala.math.Pi

object ClockHands {

  def secondsHandSlopeDiscrete: Double = {
    val currentSeconds: Int = Calendar.getInstance().get(Calendar.SECOND)
    if (currentSeconds < 15)
      currentSeconds * (-Pi / 30) + Pi / 2
    else
      currentSeconds * (-Pi / 30) + 5 * Pi / 2
  }
}
