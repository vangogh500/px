/**
 * Ordered Field
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra

/**
 * Ordered Field
 * @see https://en.wikipedia.org/wiki/Ordered_field
 * @tparam T The type of the elements that this field is a set of
 */
trait OrderedField[T] extends Field[T] with Ordering[T]

object OrderedField {
  implicit object DoubleOrderedField extends OrderedField[Double] {
    def zero: Double = 0.0
    def one: Double = 1.0
    def negate(a: Double): Double = -a
    def reciprocate(a: Double): Double = 1/a
    def plus(a: Double, b: Double): Double = a + b
    def times(a: Double, b: Double): Double = a * b
    def compare(a: Double, b: Double): Int = java.lang.Double.compare(a, b)
  }
}
