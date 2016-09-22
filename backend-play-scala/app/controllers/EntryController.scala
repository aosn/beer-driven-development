package controllers

import javax.inject._

import play.api.mvc._

@Singleton
class EntryController @Inject() extends Controller {

  def index = Action {
    Ok("Ok")
  }

}
