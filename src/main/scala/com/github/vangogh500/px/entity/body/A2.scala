/**
 * Attribute with 1st derivative
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body

import math.VectorSpace

/**
 * Attribute with 1st derivative
 * @tparam T Numeric type representing attribute value
 * @param a Attribute value
 * @param d Rate of change of a (da/dt)
 */
case class A2[T](a: T, d: T)(implicit ev: VectorSpace[Double, T]) extends A[A2[T]] {
  def timeReduce(dt: Double): A2[T] = A2(ev.plus(a, ev.stimes(dt, d)), d)
}
