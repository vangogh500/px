/**
 * Spatial Vector
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

/**
 * Spatial Vector
 * @tparam T Numeric type the vector contains
 * @tparam Repr The type of the actual spatial vector
 */
trait V[T, Repr <: V[T, Repr]] {
  /**
   * Negate the vector
   */
  def unary_- : Repr
  /**
   * Add another vector
   * @param arg Vector to add
   */
  def +(arg: Repr): Repr
  /**
   * Subtract another vector
   * @param arg Vector to subtract with
   */
  def -(arg: Repr): Repr
  /**
   * Multiply by a scalar
   * @param a Scalar to multiply by
   */
  def *(a: T): Repr
}

/**
 * Spatial Vector
 * @tparam T Numeric type the vector contains
 * @tparam Repr The type of the actual spatial vector
 */
object V {
  /**
   * Construct a 2D vector
   */
  def apply[T](x: T, y: T)(implicit ev: Numeric[T]): V2[T] = V2(x, y)
  /**
   * Construct a 3D vector
   */
  def apply[T](x: T, y: T, z: T)(implicit ev: Numeric[T]): V3[T] = V3(x, y, z)
}
