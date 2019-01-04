/**
 * Vector Space
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra

import implicits._

/**
 * Vector space
 * @see https://en.wikipedia.org/wiki/Vector_space
 * @tparam F Scalar type
 * @tparam V Vector type
 */
trait VectorSpace[F, V] extends Any {
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
   * @param v Vector to sum
   * @param u Vector to sum
   */
  def plus(v: V, u: V): V
  /**
   * Subtract 1 vector from another
   * @param v Vector to subtract from
   * @param u Vector to subtract with
   */
  def minus(v: V, u: V): V = plus(v, negate(u))
  /**
   * Multiplies a vector by a scalar
   * @param a Scalar to multiply
   * @param v Vector to multiply
   */
  def stimes(a: F, v: V): V
  implicit class FieldElement(a: F) extends field.Element {
    def unary_- : F = field.negate(a)
    def reciprocal: F = field.reciprocate(a)
    def +(b: F): F = field.plus(a, b)
    def -(b: F): F = field.minus(a, b)
    def *(b: F): F = field.times(a, b)
    def *(v: => V): V = stimes(a,v)
    def /(b: F): F = field.div(a, b)
  }
  implicit class VectorSpaceVector(v: V) {
    def unary_- : V = negate(v)
    def +(u: V): V = plus(v, u)
    def -(u: V): V = minus(v, u)
    def *(c: F): V = stimes(c, v)
  }
}
