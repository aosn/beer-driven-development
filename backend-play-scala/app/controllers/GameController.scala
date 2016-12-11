package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc.{Action, Controller}
import services.GameService

@Singleton
class GameController @Inject()(service: GameService) extends Controller with BaseController {

  def create() = Action { implicit req =>
    Ok("")
  }

  def show(gameId: Int) = ???
  def update(gameId: Int) = ???
}
