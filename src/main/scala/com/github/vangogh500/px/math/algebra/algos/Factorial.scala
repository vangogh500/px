/**
 * Factorial algorithm
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra
package algos

/**
 * Factorial algorithm
 * @see https://en.wikipedia.org/wiki/Factorial
 */
object Factorial {
 /**
  * Helper function assumes that n >= 0
  */
 private def factorial1(n: Int): Int = n match {
   case 0 => 1
   case n => n * factorial1(n-1)
 }
 /**
  * Find the factorial of n
  */
 def apply(n: Int): Int = if(n < 0) {
   throw new ArithmeticException("Factorial of a negative number does not exist")
 } else {
   factorial1(n)
 }
 /**
  * Get factorial of number as an option
  */
 def option(n: Int): Option[Int] = if(n < 0) {
   None
 } else {
   Some(factorial1(n))
 }
}
