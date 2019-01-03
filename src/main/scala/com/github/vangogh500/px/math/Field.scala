/**
 * Field
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

/**
 * Field
 * @see https://en.wikipedia.org/wiki/Field_(mathematics)
 * @tparam C The type of the elements that this field is a set of
 */
trait Field[C] extends Any {
  /**
   * Zero element
   */
  def zero: C
  /**
   * Negate an element in the field
   * @param c The element to negate
   */
  def negate(c: C): C
  /**
   * Multiplicative inverse of the field
   * @param c The element to inverse
   */
  def reciprocal(c: C): C
  /**
   * Sums 2 elements
   * @param c1 First element to sum
   * @param c2 Second element to sum
   */
  def plus(c1: C, c2: C): C
  /**
   * Multiplies 2 elements
   * @param c1 First element to multiply
   * @param c2 Second element to multiply
   */
  def times(c1: C, c2: C): C
}

/**
 * Field
 * @see https://en.wikipedia.org/wiki/Field_(mathematics)
 * @tparam C Field type
 */
object Field {
  implicit class IntField(val c: Int) extends AnyVal with Field[Int] {
    def zero: Int = 0
    def negate(c: Int): Int = -c
    def reciprocal(c: Int): Int = 1/c
    def plus(c1: Int, c2: Int): Int = c1 + c2
    def times(c1: Int, c2: Int): Int = c1 * c2
  }
  implicit class DoubleField(val c: Double) extends AnyVal with Field[Double] {
    def zero: Double = 0.0
    def negate(c: Double): Double = -c
    def reciprocal(c: Double): Double = 1/c
    def plus(c1: Double, c2: Double): Double = c1 + c2
    def times(c1: Double, c2: Double): Double = c1 * c2
  }
}
