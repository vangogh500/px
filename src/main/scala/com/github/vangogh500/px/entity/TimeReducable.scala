/**
 * Time reducable
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity

/**
 * Time reducable
 * @tparam Repr The type of the actual time reducable entity
 */
trait TimeReducable[T] {
  /**
   * Time reduce
   * @param dt Time elapsed
   */
  def timeReduce(dt: Double, entity: T): T

  implicit class Ops(entity: T) {
    def tReduce(dt: Double): T = timeReduce(dt, entity)
  }
}
