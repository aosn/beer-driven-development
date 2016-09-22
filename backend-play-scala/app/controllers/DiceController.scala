package controllers

import javax.inject._

import play.api.mvc._
import services.DiceService

@Singleton
class DiceController @Inject()(service: DiceService) extends Controller with BaseController {

  def roll(gameId: Int) = Action { implicit req =>
    DiceForm.roll.bindFromRequest.fold(validationError[DiceRollParam], params => {
      okResult(service.roll(gameId, params))
    })
  }

}
