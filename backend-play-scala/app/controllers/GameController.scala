package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc.Controller
import services.GameService

@Singleton
class GameController @Inject()(service: GameService) extends Controller with BaseController {
  def create() = ???
  def show(gameId: Int) = ???
  def update(gameId: Int) = ???
}
