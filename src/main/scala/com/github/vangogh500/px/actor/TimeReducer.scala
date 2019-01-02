/**
 * Time reducing actor
 * @author Kai Matsuda
 */
package com.github.vangogh500
package actor

import entity.TimeReducable
import akka.actor.{ Actor, Props }

/**
 * Time reducing actor
 */
class TimeReducer[T <: TimeReducable[T]] extends Actor {
  def receive = {
    case TimeReducer.Req(dt, en: T) => sender() ! TimeReducer.Res(en.timeReduce(dt))
  }
}

/**
 * Time reducing actor
 */
object TimeReducer {
  def props[T <: TimeReducable[T]]: Props = Props(new TimeReducer[T])
  /**
   * Req message
   * @param dt Delta time
   * @param en Entity to time reduce
   */
  case class Req[T <: TimeReducable[T]](dt: Double, en: T)
  /**
   * Res message
   * @param en Entity that was time reduced
   */
  case class Res[T <: TimeReducable[T]](en: T)
}
