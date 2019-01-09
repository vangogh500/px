/**
 * Primitive EVSpace Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra

import org.scalatest.FlatSpec

/**
 * Spec for primitive ev spaces
 */
class PrimitiveEVSpaceSpec extends FlatSpec with EVSpaceBehaviors {
  "VectorSpace[Double,(Double, Double)]" should behave like evSpaceAxioms((1.0, 3.50), (0.25, 0.50), (0.50, 9.00), 4.50, 6.50)
  "VectorSpace[Double,(Double, Double, Double)]" should behave like evSpaceAxioms((1.0, 3.50, 6.25), (0.25, 0.50, 0.25), (0.50, 9.00, 2.0), 4.25, 6.50)
}
