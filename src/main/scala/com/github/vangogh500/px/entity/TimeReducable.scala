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
trait TimeReducable[Repr <: TimeReducable[Repr]] {
  /**
   * Time reduce
   * @param dt Time elapsed
   */
  def tReduce(dt: Double): Repr
}
