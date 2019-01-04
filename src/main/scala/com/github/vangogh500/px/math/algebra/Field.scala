/**
 * Field
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra

/**
 * Field
 * @see https://en.wikipedia.org/wiki/Field_(mathematics)
 * @tparam C The type of the elements that this field is a set of
 */
trait Field[C] extends Any {
  /**
   * The additive identity element
   */
  def zero: C
  /**
   * The multiplicative identity element
   */
  def one: C
  /**
   * Additive inverse of an element in the field
   * @param c The element to negate
   */
  def negate(a: C): C
  /**
   * Multiplicative inverse of an element in the field
   * @param c The element to inverse
   */
  def reciprocal(a: C): C
  /**
   * Sums 2 elements
   * @param a First element to sum
   * @param b Second element to sum
   */
  def plus(a: C, b: C): C
  /**
   * Subtracts one element from another
   * @param a Element to subtract from
   * @param b Element to subtract with
   */
  def minus(a: C, b: C): C = plus(a, negate(b))
  /**
   * Multiplies 2 elements
   * @param a First element to multiply
   * @param b Second element to multiply
   */
  def times(a: C, b: C): C
  /**
   * Divides one element from another
   * @param a Element to divide
   * @param b Element to divide using
   */
  def div(a: C, b: C): C = times(a, reciprocal(b))
}

/**
 * Field
 * @see https://en.wikipedia.org/wiki/Field_(mathematics)
 * @tparam C Field type
 */
object Field {
  implicit val doubleField = new Field[Double] {
    def zero: Double = 0.0
    def one: Double = 1.0
    def negate(a: Double): Double = -a
    def reciprocal(a: Double): Double = 1/a
    def plus(a: Double, b: Double): Double = a + b
    def times(a: Double, b: Double): Double = a * b
  }
}
