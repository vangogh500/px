/**
 * Euclid Spec
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algo

import org.scalatest.FlatSpec

/**
 * Euclid Spec
 */
class EuclidSpec extends FlatSpec with AlgebraBehaviors {
  "Euclid's algorithm" should behave like gcd(Euclid.apply)
  "Euclid's algorithm (option)" should behave like gcdOpt(Euclid.option)
}
