/**
 * Primitive Field Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra

import org.scalatest.FlatSpec

/**
 * Spec for primitive fields
 */
class PrimitiveFieldSpec extends FlatSpec with FieldBehaviors {
  "Field[Double]" should behave like fieldAxioms(1.25, 3.3, 42.0)
}
