/**
 * VectorLike
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

/**
 * VectorLike
 * @tparam F scalar type
 * @tparam Repr the type representing the vector
 */
trait VectorLike[F, Repr] {
  /**
   * Negate the vector
   */
  def unary_- : Repr
  /**
   * Add another vector
   * @param v vector to add
   */
  def +(v: Repr): Repr
  /**
   * Subtract with another vector
   * @param v vector to subtract with
   */
  def -(v: Repr): Repr
  /**
   * Multiply by a scalar value
   * @param c scalar to multiply with
   */
  def *(c: F): Repr
}
