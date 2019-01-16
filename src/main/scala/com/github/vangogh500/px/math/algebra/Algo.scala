/**
 * Collection of algebraic algorithms
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra

import algos._

/**
 * Algebraic algorithms
 * @see https://en.wikipedia.org/wiki/Euclidean_algorithm
 */
object Algo {
  /**
   * Get the factorial of n
   * @param n n
   */
  def factorial(n: Int): Int = Factorial(n)
  /**
   * Get the factorial of n as an option
   * @param n n
   */
  def factorialOpt(n: Int): Option[Int] = Factorial.option(n)
  /**
   * Find the createst common denominator of 2 integers
   * @param a Number to find GCD of
   * @param b Number to find GCD of
   * @throws ArithmeticException If a and b are both zero
   */
  def gcd(a: Int, b: Int): Int = Euclid(a, b)
  /**
   * Find the createst common denominator of 2 integers as an option
   * @param a Number to find GCD of
   * @param b Number to find GCD of
   */
  def gcdOpt(a: Int, b: Int): Option[Int] = Euclid.option(a, b)
  /**
   * Find the createst common denominator of 2 integers as an option
   * @param a Number to find GCD of
   * @param b Number to find GCD of
   */
  def lcm(a: Int, b: Int): Int =  a * b / Euclid(a, b)
}
