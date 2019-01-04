/**
 * Vector Space
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

/**
 * Vector space
 * @see https://en.wikipedia.org/wiki/Vector_space
 * @tparam F Scalar type
 * @tparam V Vector type
 */
trait VectorSpace[F, V] {
  /**
   * Evidance that F is a scalar belonging to a field
   */
  def field: Field[F]
  /**
   * Zero vector
   */
  def zero: V
  /**
   * Negate a vector
   * @param v Vector to negate
   */
  def negate(v: V): V
  /**
   * Sums 2 vectors
   * @param v1 Vector to sum
   * @param v2 Vector to sum
   */
  def plus(v1: V, v2: V): V
  /**
   * Subtract 1 vector from another
   * @param v1 Vector to subtract from
   * @param v2 Vector to subtract with
   */
  def minus(v1: V, v2: V): V = plus(v1, negate(v2))
  /**
   * Multiplies a vector by a scalar
   * @param a Scalar to multiply
   * @param v Vector to multiply
   */
  def stimes(a: F, v: V): V
}
