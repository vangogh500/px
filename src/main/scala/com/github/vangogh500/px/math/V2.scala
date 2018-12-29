/**
 * 2D Vector
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

/**
 * 2D Vector
 * @tparam T Numeric type representing the values in the 2 spacial dimensions
 * @param x Value in x coordinate
 * @param y Value in y coordinate
 */
case class V2[T](x: T, y: T)(implicit ev: Numeric[T]) extends V[T, V2[T]] {
  def unary_- = V2(ev.negate(x), ev.negate(y))
  def +(arg: V2[T]): V2[T] = V2(ev.plus(x, arg.x), ev.plus(y, arg.y))
  def -(arg: V2[T]): V2[T] = this + -arg
  def *(a: T): V2[T] = V2(ev.times(x, a), ev.times(y, a))
}

/**
 * 2D Vector
 */
object V2 {
  /**
   * Double-IntV2 Vector space
   */
  implicit val doubleintVec2Space: VectorSpace[Double, V2[Int]] = new VectorSpace[Double, V2[Int]] {
    def zero: V2[Int] = V2(0, 0)
    def negate(v: V2[Int]): V2[Int] = -v
    def plus(v1: V2[Int], v2: V2[Int]): V2[Int] = v1 + v2
    def stimes(a: Double, v: V2[Int]): V2[Int] = v * a.toInt
  }
  /**
   * Double-DoubleV2 Vector space
   */
  implicit val doubledoubleVec2Space: VectorSpace[Double, V2[Double]] = new VectorSpace[Double, V2[Double]] {
    def zero: V2[Double] = V2(0, 0)
    def negate(v: V2[Double]): V2[Double] = -v
    def plus(v1: V2[Double], v2: V2[Double]): V2[Double] = v1 + v2
    def stimes(a: Double, v: V2[Double]): V2[Double] = v * a
  }
}
