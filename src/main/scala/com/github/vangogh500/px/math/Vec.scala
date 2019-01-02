/**
 * Spatial Vector
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

/**
 * Vector
 * @tparam F scalar type
 * @tparam V vector type
 */
case class Vec[F,V](args: V*)(implicit ev: VectorSpace[F,V]) {
  /**
   * Negate the vector
   */
  def unary_- = Vec(args.map(ev.negate(_)): _*)
  /**
   * Add another vector
   * @param arg Vector to add
   */
  def +(v: Vec[F,V]): Vec[F,V] = v match {
    case Vec(args2 @ _*) => Vec(
      args.zipAll(args2, ev.zero, ev.zero).map {
        case (x1, x2) => ev.plus(x1, x2)
      }: _*
    )
  }
  /**
   * Subtract another vector
   * @param arg Vector to subtract with
   */
  def -(v: Vec[F,V]): Vec[F,V] = v match {
    case Vec(args2 @ _*) => Vec(
      args.zipAll(args2, ev.zero, ev.zero).map {
        case (x1, x2) => ev.plus(x1, ev.negate(x2))
      }: _*
    )
  }
  /**
   * Multiply by a scalar
   * @param a Scalar to multiply by
   */
  def *(a: F): Vec[F,V] = Vec(args.map(ev.stimes(a, _)): _*)
}

/**
 * Vector
 * @tparam T Numeric type the vector contains
 */
object Vec {
  /**
   * Unapply a vector
   */
  def unapplySeq[F,V](v: Vec[F,V]): Option[Seq[V]] = v match {
    case Vec(args @ _*) => Some(args)
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
