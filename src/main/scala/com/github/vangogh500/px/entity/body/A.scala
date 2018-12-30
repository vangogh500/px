/**
 * Attribute
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body

import math.VectorSpace

/**
 * Attribute
 * @tparam Repr The type of the actual attribute
 */
trait A[Repr <: A[Repr]] extends TimeReducable[Repr]

/**
 * Attribute
 */
object A {
  def apply[T](a: T)(implicit ev: VectorSpace[Double, T]): A1[T] = A1(a)
  def apply[T](a: T, d: T)(implicit ev: VectorSpace[Double, T]): A2[T] = A2(a, d)
  def apply[T](a: T, d: T, dd: T)(implicit ev: VectorSpace[Double, T]): A3[T] = A3(a, d, dd)
}
