/**
 * Rational number
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

import algo.Algebra

/**
 * Rational number
 * @see https://en.wikipedia.org/wiki/Rational_number
 */
case class Rational(n: Int, d: Int)

/**
 * Rational number
 * @see https://en.wikipedia.org/wiki/Rational_number
 */
object Rational {
  /**
   * Factory method for creating a rational from an int
   * @param n Int to convert to a rational
   */
  def apply(n: Int): Rational = new Rational(n, 1)
  /**
   * Factory method using a numerator and denominator
   * @param n Numerator
   * @param d Denominator
   * @throws ArithmeticException When the denominator is zero
   */
  def apply(n: Int, d: Int): Rational = if(d != 0) {
    val gcd = Algebra.gcd(n, d)
    new Rational(n / gcd, d / gcd)
  } else {
    throw new ArithmeticException("Cannot divide by zero")
  }
  /**
   * Create an option of a rational number using a numerator and denominator
   * @param n Numerator
   * @param d Denominator
   */
  def option(n: Int, d: Int): Option[Rational] = if(d != 0) Some(new Rational(n, d)) else None
  /**
   * Field associated with the rational number set
   */
  implicit val field: Field[Rational] = new Field[Rational] {
    def zero: Rational = Rational(0, 1)
    def negate(c: Rational): Rational = c match {
      case Rational(n, d) => new Rational(-n, d)
    }
    def reciprocal(c: Rational): Rational = c match {
      case Rational(n, d) => new Rational(d, n)
    }
    def times(c1: Rational, c2: Rational): Rational = (c1, c2) match {
      case (Rational(n1, d1), Rational(n2, d2)) => Rational(n1 * n2, d1 * d2)
    }
    def plus(c1: Rational, c2: Rational): Rational = (c1, c2) match {
      case (Rational(n1, d1), Rational(n2, d2)) =>
        val gcd = Algebra.gcd(d1, d2)
        new Rational((n1 * d2 / gcd) + (n2 * d1 / gcd), (d1 * d2 / gcd))
    }
  }
}
