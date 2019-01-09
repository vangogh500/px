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
class PrimitivePolySpec extends FlatSpec with EVSpaceBehaviors {
  "VectorSpace[Double,Poly[Double]]" should behave like evSpaceAxioms(Poly(1.0, 3.50), Poly(0.25), Poly(0.50, 9.00, 3.25), 4.50, 6.50)
  it should "values should be correctly applied" in {
    val f = Poly(1.0, 2.0, 3.0)
    assert(f(4) == 1 + 8 + 16 * 3)
    assert(f(6.5) == 1 + 13 + Math.pow(6.5,2) * 3)
    val g = Poly(3.5, -1.5, 0.25)
    assert(g(-3.0) == 3.5 + (-1.5 * -3) + (9 * 0.25))
    assert(g(0) == 3.5)
  }
}
