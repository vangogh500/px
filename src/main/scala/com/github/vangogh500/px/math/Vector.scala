/**
 * Spatial vector
 * @see https://en.wikipedia.org/wiki/Euclidean_vector
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

/**
 * Spatial vector
 * @see https://en.wikipedia.org/wiki/Euclidean_vector
 * @tparam F scalar type
 * @tparam V vector type
 */
case class Vector[F,V](args: V*)(implicit val ev: VectorSpace[F, Vector[F,V]])

/**
 * Spatial vector
 * @see https://en.wikipedia.org/wiki/Euclidean_vector
 * @tparam T Numeric type the vector contains
 */
object Vector {
  /**
   * Unapply a vector
   */
  def unapplySeq[F,V](v: Vector[F,V]): Option[Seq[V]] = v match {
    case Vector(args @ _*) => Some(args)
  }
  /**
   * Vector-Vector Space
   */
  implicit def vectorSpace[F,V](implicit ev: VectorSpace[F,V]): VectorSpace[F, Vector[F, V]] = new VectorSpace[F, Vector[F, V]] {
    def zero: Vector[F, V] = Vector()
    def negate(v1: Vector[F, V]): Vector[F, V] = v1 match {
      case Vector(args1 @ _*) => Vector(args1.map(ev.negate(_)): _*)
    }
    def plus(v1: Vector[F, V], v2: Vector[F, V]): Vector[F, V] = (v1, v2) match {
      case (Vector(args1 @ _*), Vector(args2 @ _*)) => Vector(
        args1.zipAll(args2, ev.zero, ev.zero).map {
          case (arg1, arg2) => ev.plus(arg1, arg2)
        }: _*
      )
    }
    def stimes(a: F, v: Vector[F, V]): Vector[F, V] = v match {
      case Vector(args1 @ _*) => Vector(args1.map(ev.stimes(a, _)): _*)
    }
  }
}
