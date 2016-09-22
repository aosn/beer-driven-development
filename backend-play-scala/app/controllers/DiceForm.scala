package controllers

import play.api.data.Form
import play.api.data.Forms._

object DiceForm {
  def roll = Form(
    mapping(
      "times" -> number(min = 1)
    )(DiceRollParam.apply)(DiceRollParam.unapply)
  )
}

case class DiceRollParam(times: Int)
