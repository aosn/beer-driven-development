package util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

import scala.util.Try

object JsonSerializer {
  private[this] val MAPPER = new ObjectMapper with ScalaObjectMapper
  MAPPER.registerModule(DefaultScalaModule)

  def serialize(o: AnyRef): String = {
    MAPPER.writeValueAsString(o)
  }

  def deserialize[T](json: String): Try[T] = {
    Try(MAPPER.readValue(json))
  }
}
