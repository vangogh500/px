/**
 * Algebra Spec
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algo

import org.scalatest.FlatSpec

/**
 * Algebra Spec
 */
class AlgebraSpec extends FlatSpec with AlgebraBehaviors {
  "Algebra.gcd" should behave like gcd(Algebra.gcd)
  "Algebra.gcdOpt" should behave like gcdOpt(Algebra.gcdOpt)
}
