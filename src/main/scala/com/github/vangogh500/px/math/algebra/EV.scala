/**
 * Euclidean vector
 * @see https://en.wikipedia.org/wiki/Euclidean_vector
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra

/**
 * Euclidean vector
 * @see https://en.wikipedia.org/wiki/Euclidean_vector
 * @tparam F scalar type
 * @tparam V vector type
 */
case class EV[F](args: F*)(implicit ev: Field[F]) {
  override def equals(u: Any): Boolean = u match {
    case EV(args2 @ _ *) =>
      (args.forall(_ == ev.zero) && args2.forall(_ == ev.zero)) || (args == args2)
    case _ => false
  }
}

/**
 * Euclidean vector
 * @see https://en.wikipedia.org/wiki/Euclidean_vector
 */
object EV {
  /**
   * Unapply a vector
   */
  def unapplySeq[F](v: EV[F]): Option[Seq[F]] = v match {
    case EV(args @ _*) => Some(args)
  }
  /**
   * Construct a vector using ints
   */
  def apply(arg: Int, args: Int*): EV[Double] = EV(arg.toDouble +: args.map(_.toDouble):_*)
  /**
   * EV Vector space
   */
  implicit def vectorSpace[F](implicit ev: Field[F]): VectorSpace[F, EV[F]] = new VectorSpace[F, EV[F]] {
    def field: Field[F] = ev
    def zero: EV[F] = EV()
    def negate(v: EV[F]): EV[F] = v match {
      case EV(args1 @ _*) => EV(args1.map(ev.negate(_)): _*)
    }
    def plus(v: EV[F], u: EV[F]): EV[F] = (v, u) match {
      case (EV(args1 @ _*), EV(args2 @ _*)) => EV(
        args1.zipAll(args2, ev.zero, ev.zero).map {
          case (arg1, arg2) => ev.plus(arg1, arg2)
        }: _*
      )
    }
    def stimes(a: F, v: EV[F]): EV[F] = v match {
      case EV(args1 @ _*) => EV(args1.map(ev.times(a, _)): _*)
    }
  }
}
