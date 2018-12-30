/**
 * Attribute with 2nd derivative
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body

import math.VectorSpace

/**
 * Attribute with 2nd derivative
 * @tparam T Numeric type representing attribute value
 * @param a Attribute value
 * @param d Rate of change of a (da/dt)
 * @param dd Rate of change of da (da^2/dt^2)
 */
case class A3[T](a: T, d: T, dd: T)(implicit ev: VectorSpace[Double, T]) extends A[A3[T]] {
  def timeReduce(dt: Double): A3[T] = A3(
    ev.plus(ev.plus(a, ev.stimes(dt, d)), ev.stimes(0.5 * Math.pow(dt, 2), dd)),
    ev.plus(d, ev.stimes(dt, dd)),
    dd
  )
}
