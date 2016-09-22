package com.github.aosn.play

import play.api.data.FormError

object ValidationError {

  /** Seq[FormError]をタプルのリストに */
  def mkErrorString[A](errors: Seq[FormError]): Seq[(String, String)] = {
    errors.map {
      case e if e.message.contains(": ") =>
        e.message.split(": ", 2) match {
          case Array(key, message) => (key, message)
        }
      case e =>
        (e.key, e.message.toString)
    }
  }
}
