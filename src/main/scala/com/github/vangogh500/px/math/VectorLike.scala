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
trait VectorLike[F, Repr <: VectorLike[F,Repr]] {
  /**
   * Internal representation of itself as the vector type
   */
  private val self = this.asInstanceOf[Repr]
  /**
   * Evidence that the vector has an associated vector space
   */
  implicit val ev: VectorSpace[F, Repr]
  /**
   * Negate the vector
   */
  def unary_- = ev.negate(self)
  /**
   * Add another vector
   * @param v vector to add
   */
  def +(v: Repr): Repr = ev.plus(self, v)
  /**
   * Subtract with another vector
   * @param v vector to subtract with
   */
  def -(v: Repr): Repr = ev.plus(self, ev.negate(v))
  /**
   * Multiply by a scalar value
   * @param c scalar to multiply with
   */
  def *(c: F): Repr = ev.stimes(c, self)
}
