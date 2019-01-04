/**
 * Field Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

import implicits._
import org.scalatest.FlatSpec

/**
 * Spec for primitive fields
 */
class PrimitiveFieldSpec extends FlatSpec with FieldBehaviors {
  "Field[Int]" should behave like axioms(4, 7, 13)
  "Field[Double]" should behave like axioms(1.25, 3.3, 42.0)
}
