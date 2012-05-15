package controllers

import modules.GuessResult
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

object Application extends Controller {

  val form = Form("guess" -> number(min=0, max=9));
  val correctGuess = GuessResult.randomNumber()
  
  def index = Action {
    Ok(views.html.index("din tur kajsa"))
  }
  
  def guess = Action { implicit request =>
    form.bindFromRequest.fold(
      errors => BadRequest(views.html.guess(form, GuessResult.from(-1, correctGuess))),
      result => Ok(views.html.guess(form, GuessResult.from(result, correctGuess)))
    )
  }
}