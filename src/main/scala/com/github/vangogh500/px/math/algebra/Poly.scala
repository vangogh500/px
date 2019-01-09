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
case class Poly[F](coeffs: F*)(implicit ev: OrderedField[F]) {
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
   * EVSpace for Polynomials
   */
  implicit def evSpace[F](implicit ev: OrderedField[F]): EVSpace[F, Poly[F]] = new EVSpace[F, Poly[F]]{
    def field: OrderedField[F] = ev
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
}
