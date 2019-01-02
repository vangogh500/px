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
   * Multiplies a vector by a scalar
   * @param a Scalar to multiply
   * @param v Vector to multiply
   */
  def stimes(a: F, v: V): V
}

/**
 * Vector space
 * @see https://en.wikipedia.org/wiki/Vector_space
 */
object VectorSpace {
  /**
   * Double-Int Vector Space
   */
  implicit val doubleintSpace: VectorSpace[Double, Int] = new VectorSpace[Double, Int] {
    def zero: Int = 0
    def negate(v: Int): Int = -v
    def plus(v1: Int, v2: Int): Int = v1 + v2
    def stimes(a: Double, v: Int): Int = a.toInt * v
  }
  /**
   * Double-Double Vector Space
   */
  implicit val doubledoubleSpace: VectorSpace[Double, Double] = new VectorSpace[Double, Double] {
    def zero: Double = 0
    def negate(v: Double): Double = -v
    def plus(v1: Double, v2: Double): Double = v1 + v2
    def stimes(a: Double, v: Double): Double = a * v
  }
}
