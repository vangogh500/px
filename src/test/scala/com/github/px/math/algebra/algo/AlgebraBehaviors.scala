/**
 * Alegebra behaviors
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra
package algo

import org.scalatest.FlatSpec

/**
 * Euclid Spec
 */
trait AlgebraBehaviors { this: FlatSpec =>
  def gcd(f: (Int, Int) => Int) {
    it should "throw an ArithmeticException on (0,0)" in {
      assertThrows[ArithmeticException] {
        f(0, 0)
      }
    }
    it should "produce the correct gcds" in {
      assert(f(1, 3) == 1)
      assert(f(81, 9) == 9)
      assert(f(12, 15) == 3)
      assert(f(270, 144) == 18)
    }
  }
  def gcdOpt(f: (Int, Int) => Option[Int]) {
    it should "return None on (0,0)" in {
      assert(f(0, 0) == None)
    }
    it should "produce the correct gcds" in {
      assert(f(1, 3) == Some(1))
      assert(f(81, 9) == Some(9))
      assert(f(12, 15) == Some(3))
      assert(f(270, 144) == Some(18))
    }
  }
}
