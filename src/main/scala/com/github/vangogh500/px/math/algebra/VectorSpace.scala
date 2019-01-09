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
  /**
   * Rich ops wrapper for vectors
   * @param v vector
   */
  class VectorOps(v: V) {
    /**
     * Negate
     */
    def unary_- : V = negate(v)
    /**
     * Add vector
     * @param u vector to add
     */
    def +(u: V): V = plus(v, u)
    /**
     * Subtract vector
     * @param u vector to subtract with
     */
    def -(u: V): V = minus(v, u)
    /**
     * Multiply by a scalar
     * @param c scalar to multiply with
     */
    def *(c: F): V = stimes(c, v)
  }
  /**
   * Implicit decoration of vectors using operators defined in VectorOps
   */
  implicit def mkVectorOps(v: V): VectorOps = new VectorOps(v)
  /**
   * Rich ops wrapper for scalars
   * @param f scalar
   */
  class FieldOps(a: F) {
    /**
     * Negate (additive inverse)
     */
    def unary_- : F = field.negate(a)
    /**
     * Reciprocal (multiplicative inverse)
     */
    def reciprocal: F = field.reciprocate(a)
    /**
     * Add scalar
     * @param b scalar to add
     */
    def +(b: F): F = field.plus(a, b)
    /**
     * Subtract scalar
     * @param b scalar to subtract with
     */
    def -(b: F): F = field.minus(a, b)
    /**
     * Multiply scalar
     * @param b scalar to multiply
     */
    def *(b: F): F = field.times(a, b)
    /**
     * Divide by scalar
     * @param b scalar to divide by
     */
    def /(b: F): F = field.div(a, b)
    /**
     * Multiply vector
     * @param v vector to multiply
     */
    def *(v: => V): V = stimes(a,v)
  }
  /**
   * Implicit decoration of scalars using operators defined in FieldOps
   */
  implicit def mkFieldOps(a: F): FieldOps = new FieldOps(a)
}
