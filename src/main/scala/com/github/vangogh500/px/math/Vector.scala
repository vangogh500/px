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
case class Vector[F](args: F*)(implicit val ev: VectorSpace[F, Vector[F]])

/**
 * Spatial vector
 * @see https://en.wikipedia.org/wiki/Euclidean_vector
 * @tparam T Numeric type the vector contains
 */
object Vector {
  /**
   * Unapply a vector
   */
  def unapplySeq[F](v: Vector[F]): Option[Seq[F]] = v match {
    case Vector(args @ _*) => Some(args)
  }
  /**
   * Vector-Vector Space
   */
  implicit def vectorSpace[F](implicit ev: Field[F]): VectorSpace[F, Vector[F]] = new VectorSpace[F, Vector[F]] {
    def field: Field[F] = ev
    def zero: Vector[F] = Vector()
    def negate(v1: Vector[F]): Vector[F] = v1 match {
      case Vector(args1 @ _*) => Vector(args1.map(ev.negate(_)): _*)
    }
    def plus(v1: Vector[F], v2: Vector[F]): Vector[F] = (v1, v2) match {
      case (Vector(args1 @ _*), Vector(args2 @ _*)) => Vector(
        args1.zipAll(args2, ev.zero, ev.zero).map {
          case (arg1, arg2) => ev.plus(arg1, arg2)
        }: _*
      )
    }
    def stimes(a: F, v: Vector[F]): Vector[F] = v match {
      case Vector(args1 @ _*) => Vector(args1.map(ev.times(a, _)): _*)
    }
  }
}
