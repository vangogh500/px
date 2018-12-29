/**
 * Static attribute
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body
package attribute

import math.VectorSpace

/**
 * Static attribute
 * @tparam T Numeric type representing attribute value
 * @param a Attribute value
 */
case class A1[T](a: T)(implicit ev: VectorSpace[Double, T]) extends TimeReducable[A1[T]] {
  def timeReduce(dt: Double): A1[T] = this
}
