/**
 * Spatial Vector
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

/**
 * Vector
 * @tparam T Numeric type the vector contains
 */
trait Vec[F, V] {
  /**
   * Evidence of vector space
   */
  implicit val ev: VectorSpace[F,V]
  /**
   * Negate the vector
   */
  def unary_- : Vec[F,V]
  /**
   * Add another vector
   * @param arg Vector to add
   */
  def +(v: Vec[F, V]): Vec[F,V]
  /**
   * Subtract another vector
   * @param arg Vector to subtract with
   */
  def -(v: Vec[F, V]): Vec[F,V]
  /**
   * Multiply by a scalar
   * @param a Scalar to multiply by
   */
  def *(a: F): Vec[F,V]
  /**
   * Transform vector to sequence
   */
  def toSeq: Seq[V]
}

/**
 * 1D Vector
 */
case class Vec1[F,V](x: V)(implicit val ev: VectorSpace[F,V]) extends Vec[F, V] {
  def unary_- = Vec1(ev.negate(x))
  def +(v: Vec[F,V]): Vec[F,V] = v match {
    case Vec1(x2) => Vec1(ev.plus(x, x2))
    case Vec2(x2, y2) => Vec2(ev.plus(x,x2), y2)
    case Vec3(x2, y2, z2) => Vec3(ev.plus(x,x2), y2, z2)
  }
  def -(v: Vec[F,V]): Vec[F,V] = v match {
    case Vec1(x2) => Vec1(ev.plus(x, ev.negate(x2)))
    case Vec2(x2, y2) => Vec2(ev.plus(x,ev.negate(x2)), ev.negate(y2))
    case Vec3(x2, y2, z2) => Vec3(ev.plus(x,ev.negate(x2)), ev.negate(y2), ev.negate(z2))
  }
  def *(a: F): Vec[F,V] = Vec1(ev.stimes(a, x))
  def toSeq: Seq[V] = Seq(x)
}

/**
 * 2D Vector
 */
case class Vec2[F,V](x: V, y: V)(implicit val ev: VectorSpace[F,V]) extends Vec[F, V] {
  def unary_- = Vec2(ev.negate(x), ev.negate(y))
  def +(v: Vec[F,V]): Vec[F,V] = v match {
    case Vec1(x2) => Vec2(ev.plus(x,x2), y)
    case Vec2(x2, y2) => Vec2(ev.plus(x,x2), ev.plus(y,y2))
    case Vec3(x2, y2, z2) => Vec3(ev.plus(x,x2), ev.plus(y,y2), z2)
  }
  def -(v: Vec[F,V]): Vec[F,V] = v match {
    case Vec1(x2) => Vec2(ev.plus(x,ev.negate(x2)), y)
    case Vec2(x2, y2) => Vec2(ev.plus(x,ev.negate(x2)), ev.plus(y,ev.negate(y2)))
    case Vec3(x2, y2, z2) => Vec3(ev.plus(x,ev.negate(x2)), ev.plus(y,ev.negate(y2)), ev.negate(z2))
  }
  def *(a: F): Vec[F,V] = Vec2(ev.stimes(a, x), ev.stimes(a, y))
  def toSeq: Seq[V] = Seq(x,y)
}

/**
 * 3D Vector
 */
case class Vec3[F,V](x: V, y: V, z: V)(implicit val ev: VectorSpace[F,V]) extends Vec[F, V] {
  def unary_- = Vec3(ev.negate(x), ev.negate(y), ev.negate(z))
  def +(v: Vec[F,V]): Vec[F,V] = v match {
    case Vec1(x2) => Vec3(ev.plus(x,x2), y, z)
    case Vec2(x2, y2) => Vec3(ev.plus(x,x2), ev.plus(y,y2), z)
    case Vec3(x2, y2, z2) => Vec3(ev.plus(x,x2), ev.plus(y,y2), ev.plus(z,z2))
  }
  def -(v: Vec[F,V]): Vec[F,V] = v match {
    case Vec1(x2) => Vec3(ev.plus(x,ev.negate(x2)), y, z)
    case Vec2(x2, y2) => Vec3(ev.plus(x,ev.negate(x2)), ev.plus(y,ev.negate(y2)), z)
    case Vec3(x2, y2, z2) => Vec3(ev.plus(x,ev.negate(x2)), ev.plus(y,ev.negate(y2)), ev.plus(z,ev.negate(z2)))
  }
  def *(a: F): Vec[F,V] = Vec3(ev.stimes(a, x), ev.stimes(a, y), ev.stimes(a, z))
  def toSeq: Seq[V] = Seq(x,y,z)
}

/**
 * Vector
 * @tparam T Numeric type the vector contains
 */
object Vec {
  /**
   * Construct a 1D vector
   */
  def apply[F,V](x: V)(implicit ev: VectorSpace[F,V]): Vec[F,V] = Vec1(x)
  /**
   * Construct a 2D vector
   */
  def apply[F,V](x: V, y: V)(implicit ev: VectorSpace[F,V]): Vec[F,V] = Vec2(x,y)
  /**
   * Construct a 3D vector
   */
  def apply[F,V](x: V, y: V, z: V)(implicit ev: VectorSpace[F,V]): Vec[F,V] = Vec3(x,y,z)
  /**
   * Unapply a vector
   */
  def unapplySeq[F,V](v: Vec[F,V]): Option[List[V]] = v match {
    case Vec1(x) => Some(List(x))
    case Vec2(x, y) => Some(List(x, y))
    case Vec3(x, y, z) => Some(List(x, y, z))
  }
  /**
   * Double-Vec[Double, Double] Vector space
   */
  implicit val doubleDoubleDoubleVecSpace: VectorSpace[Double, Vec[Double, Double]] = new VectorSpace[Double, Vec[Double, Double]] {
    def zero: Vec[Double, Double] = Vec(0.0)
    def negate(v: Vec[Double, Double]): Vec[Double, Double] = -v
    def plus(v1: Vec[Double, Double], v2: Vec[Double, Double]): Vec[Double, Double] = v1 + v2
    def stimes(a: Double, v: Vec[Double, Double]): Vec[Double, Double] = v * a
  }
}
