/**
 * 3D Vector
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

/**
 * 3D Vector
 * @tparam T Numeric type representing the values in the 3 spacial dimensions
 * @param x Value in x coordinate
 * @param y Value in y coordinate
 * @param z Value in z coordinate
 */
case class V3[T](x: T, y: T, z: T)(implicit ev: Numeric[T]) extends V[T, V3[T]] {
  def unary_- = V3(ev.negate(x), ev.negate(y), ev.negate(z))
  def +(arg: V3[T]): V3[T] = V3(ev.plus(x, arg.x), ev.plus(y, arg.y), ev.plus(z, arg.z))
  def -(arg: V3[T]): V3[T] = this + -arg
  def *(a: T): V3[T] = V3(ev.times(x, a), ev.times(y, a), ev.times(z, a))
}

/**
 * 3D Vector
 */
object V3 {
  /**
   * Double-IntV3 Vector space
   */
  implicit val doubleintVec3Space: VectorSpace[Double, V3[Int]] = new VectorSpace[Double, V3[Int]] {
    def zero: V3[Int] = V3(0, 0, 0)
    def negate(v: V3[Int]): V3[Int] = -v
    def plus(v1: V3[Int], v2: V3[Int]): V3[Int] = v1 + v2
    def stimes(a: Double, v: V3[Int]): V3[Int] = v * a.toInt
  }
  /**
   * Double-DoubleV3 Vector space
   */
  implicit val doubledoubleVec3Space: VectorSpace[Double, V3[Double]] = new VectorSpace[Double, V3[Double]] {
    def zero: V3[Double] = V3(0, 0, 0)
    def negate(v: V3[Double]): V3[Double] = -v
    def plus(v1: V3[Double], v2: V3[Double]): V3[Double] = v1 + v2
    def stimes(a: Double, v: V3[Double]): V3[Double] = v * a
  }
}
