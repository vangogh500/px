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
 * @tparam T The type of the elements that this field is a set of
 */
trait Field[T] extends Any {
  /**
   * The additive identity element
   */
  def zero: T
  /**
   * The multiplicative identity element
   */
  def one: T
  /**
   * Additive inverse of an element in the field
   * @param c The element to negate
   */
  def negate(a: T): T
  /**
   * Multiplicative inverse of an element in the field
   * @param c The element to inverse
   */
  def reciprocate(a: T): T
  /**
   * Sums 2 elements
   * @param a First element to sum
   * @param b Second element to sum
   */
  def plus(a: T, b: T): T
  /**
   * Subtracts one element from another
   * @param a Element to subtract from
   * @param b Element to subtract with
   */
  def minus(a: T, b: T): T = plus(a, negate(b))
  /**
   * Multiplies 2 elements
   * @param a First element to multiply
   * @param b Second element to multiply
   */
  def times(a: T, b: T): T
  /**
   * Raise an element by an int
   * @param a Element to raise by b
   * @param b Number to raise a by
   */
  def pow(a: T, b: Int): T = if(b == 0) {
    one
  } else if(b > 0) {
    times(a, pow(a, b - 1))
  } else {
    times(a.reciprocal, pow(a, b + 1))
  }
  /**
   * Divides one element from another
   * @param a Element to divide
   * @param b Element to divide using
   */
  def div(a: T, b: T): T = times(a, reciprocate(b))

  /**
   * Rich ops wrapper for elements
   * @param a field element
   */
  implicit class Ops(a: T) {
    /**
     * Negate (additive inverse)
     */
    def unary_- : T = negate(a)
    /**
     * Reciprocal (multiplicative inverse)
     */
    def reciprocal: T = reciprocate(a)
    /**
     * Add
     * @param b element to add
     */
    def +(b: T): T = plus(a, b)
    /**
     * Subtract
     * @param b element to divide with
     */
    def -(b: T): T = minus(a, b)
    /**
     * Multiply
     * @param b element to multiply by
     */
    def *(b: T): T = times(a, b)
    /**
     * Raise to an exponent
     * @param b exponent to raise to
     */
    def **(b: Int): T = pow(a, b)
    /**
     * Divide
     * @param b element to divide by
     */
    def /(b: T): T = div(a, b)
  }
}

/**
 * Field
 * @see https://en.wikipedia.org/wiki/Field_(mathematics)
 * @tparam T Field type
 */
object Field {
  /**
   * Field for Double
   */
  implicit object Double extends Field[Double] {
    def zero: Double = 0.0
    def one: Double = 1.0
    def negate(a: Double): Double = -a
    def reciprocate(a: Double): Double = 1/a
    def plus(a: Double, b: Double): Double = a + b
    def times(a: Double, b: Double): Double = a * b
  }
}
