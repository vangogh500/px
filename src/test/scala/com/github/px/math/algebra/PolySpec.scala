/**
 * Poly Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra

import org.scalatest.FlatSpec

/**
 * Spec for poly
 */
class PolySpec extends FlatSpec with VSpaceBehaviors {
  "VectorSpace[Double,Poly[Double]]" should behave like vSpaceAxioms(Poly(1.0, 3.50), Poly(0.25), Poly(0.50, 9.00, 3.25), 4.50, 6.50)
  "VectorSpace[Double,(Poly[Double], Poly[Double])]" should behave like vSpaceAxioms(
    (Poly(1.0, 3.50), Poly(2.5)),
    (Poly(0.25), Poly()),
    (Poly(0.50, 9.00, 3.25), Poly(0.25, 0.5)),
    4.50, 6.50)
  "VectorSpace[Double,(Poly[Double], Poly[Double], Poly[Double])]" should behave like vSpaceAxioms(
    (Poly(), Poly(), Poly()),
    (Poly(0.25), Poly(), Poly(1.0)),
    (Poly(0.50, 9.00, 3.25), Poly(0.25, 0.5), Poly(0.0, 3.25)),
    4.50, 6.50)
  "Poly[Double]" should "be correctly applied" in {
    val f = Poly(1.0, 2.0, 3.0)
    assert(f(4) == 1 + 8 + 16 * 3)
    assert(f(6.5) == 1 + 13 + Math.pow(6.5,2) * 3)
    val g = Poly(3.5, -1.5, 0.25)
    assert(g(-3.0) == 3.5 + (-1.5 * -3) + (9 * 0.25))
    assert(g(0) == 3.5)
  }
  "(Poly[Double], Poly[Double])" should "be correctly applied" in {
    val f = (Poly(1.0, 2.0, 3.0), Poly(3.5, -1.5, 0.25))
    assert(f(4) == (1 + 8 + 16 * 3, 3.5 + -1.5 * 4 + 16 * 0.25))
    assert(f(-3) == (1 + -3 * 2.0 + 9 * 3.0, 3.5 + -3 * -1.5 + 9 * 0.25))
    assert(f(0) == (1, 3.5))
  }
}
