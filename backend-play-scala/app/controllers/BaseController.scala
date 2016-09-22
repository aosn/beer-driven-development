package controllers

import com.github.aosn.play.ValidationError
import play.api.data.Form
import play.api.mvc.Result
import play.api.mvc.Results._
import util.JsonSerializer

import scala.util.Try

trait BaseController {

  def validationError[A](form: Form[A]): Result =
    validationError(ValidationError.mkErrorString(form.errors))

  def validationError(results: Seq[(String, String)]): Result = {
    BadRequest(JsonSerializer.serialize("errors" -> results.toMap))
  }

  def okJson(res: AnyRef): Result = {
    Ok(JsonSerializer.serialize(res))
  }

  def okResult[T <: AnyRef](a: Try[T]): Result = {
    okJson(a.get)
  }

}
