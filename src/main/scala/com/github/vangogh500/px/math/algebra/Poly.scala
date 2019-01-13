/**
 * Polynomial
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra

/**
 * Polynomial
 * Of the form: f(x) = a*x^0 + b*x^1 + c*x^2 ...
 * @see https://en.wikipedia.org/wiki/Polynomial
 * @param coeffs the coefficients of the polynomial (a, b, c...)
 */
case class Poly[F](coeffs: F*)(implicit ev: Field[F]) extends (F => F) {
  import ev._
  override def equals(that: Any): Boolean = that match {
    case Poly(coeffs2 @ _*) => coeffs.zipAll(coeffs2, zero, zero).forall {
      case (a, b) => a == b
    }
  }
  /**
   * Apply a value to the polynomial function
   */
  def apply(x: F): F = coeffs.zipWithIndex.foldLeft(zero) {
    case (sum, (coeff, i)) => sum + (coeff * (x ** i))
  }
}

/**
 * Polynomial
 * @see https://en.wikipedia.org/wiki/Polynomial
 */
object Poly {
  /**
   * VSpace for Polynomials
   */
  implicit def vspace[F](implicit ev: Field[F]): VSpace[F, Poly[F]] = new VSpace[F, Poly[F]] {
    def field: Field[F] = ev
    def zero: Poly[F] = Poly()
    def negate(f: Poly[F]): Poly[F] = f match {
      case Poly(coeffs @ _*) => Poly(coeffs.map(ev.negate(_)): _*)
    }
    def plus(f: Poly[F], g: Poly[F]): Poly[F] = (f, g) match {
      case (Poly(coeffs1 @ _*), Poly(coeffs2 @ _*)) =>
        Poly(coeffs1.zipAll(coeffs2, ev.zero, ev.zero).map {
          case (a, b) => ev.plus(a, b)
        }: _*)
    }
    def stimes(c: F, f: Poly[F]): Poly[F] = f match {
      case Poly(coeffs @ _*) => Poly(coeffs.map(ev.times(_,c)): _*)
    }
  }
  /**
   * Implicit conversion to work with vector2 valued functions
   */
   implicit def vector2ValuedFunction[F](v: (Poly[F], Poly[F])) = v match {
     case (p1, p2) => (x: F) => (p1(x), p2(x))
   }
   /**
    * Implicit conversion to work with vector3 valued functions
    */
    implicit def vector3ValuedFunction[F](v: (Poly[F], Poly[F], Poly[F])) = v match {
      case (p1, p2, p3) => (x: F) => (p1(x), p2(x), p3(x))
    }
}
