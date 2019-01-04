/**
 * Euclid's algorithm
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra
package algo

/**
 * Euclid's algorithm
 * @see https://en.wikipedia.org/wiki/Euclidean_algorithm
 */
object Euclid {
  /**
   * Find the gcd of 2 numbers (assumes that a or b is nonzero)
   * @param a Number to find GCD of
   * @param b Number to find GCD of
   */
  private def gcd1(a: Int, b: Int): Int = if(b == 0) a.abs else gcd1(b, a % b)
  /**
   * Get the GCD for a pair of integers
   * @param a Number to find GCD of
   * @param b Number to find GCD of
   * @throws ArithmeticException When both a and b are zero
   */
  def apply(a: Int, b: Int): Int = if(a == 0 && b == 0) {
    throw new ArithmeticException("gcd(0,0) DNE")
  } else gcd1(a, b)
  /**
   * Get the GCD for a pair of integers as an option
   * @param a Number to find GCD of
   * @param b Number to find GCD of
   */
  def option(a: Int, b: Int): Option[Int] = (a, b) match {
    case (0, 0) => None
    case (a, b) => Some(gcd1(a, b))
  }
}
