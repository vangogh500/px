/**
 * Primitive Ordered Field Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra

import org.scalatest.FlatSpec

/**
 * Spec for primitive ordered fields
 */
class PrimitiveOrderedFieldSpec extends FlatSpec with OrderedFieldBehaviors {
  "OrderedField[Double]" should behave like orderedFieldAxioms(1.25, 3.3, 42.0)
}
