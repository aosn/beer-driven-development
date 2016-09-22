package services

import javax.inject._

import controllers.DiceRollParam

import scala.util.{Random, Success, Try}

trait DiceService {
  def roll(gameId: Int, params: DiceRollParam): Try[DiceRollResult]
}

@Singleton
class DiceServiceImpl @Inject()(random: Random) extends DiceService {

  override def roll(gameId: Int, params: DiceRollParam): Try[DiceRollResult] = {
    Success(DiceRollResult(Array.fill(params.times)(random.nextInt(5) + 1)))
  }

}

case class DiceRollResult(dice: Array[Int])
