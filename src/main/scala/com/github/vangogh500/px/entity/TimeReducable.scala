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
  def timeReduce(dt: Double): T
}

/**
 * Time reducable
 */
object TimeReducable {
  /**
   * Implicit time reducable of 2d vectors of time reducables
   */
  implicit class Vector2[T <: TimeReducable[T]](xy: (T,T)) extends TimeReducable[(T,T)] {
    def timeReduce(dt: Double): (T,T) = xy match {
      case (x, y) => (x.timeReduce(dt), y.timeReduce(dt))
    }
  }
  /**
   * Implicit time reducable of 3d vectors of time reducables
   */
  implicit class Vector3[T <: TimeReducable[T]](xyz: (T,T,T)) extends TimeReducable[Vector3[T]] {
    def timeReduce(dt: Double): Vector3[T] = xyz match {
      case (x, y, z) => (x.timeReduce(dt), y.timeReduce(dt), z.timeReduce(dt))
    }
  }
}
