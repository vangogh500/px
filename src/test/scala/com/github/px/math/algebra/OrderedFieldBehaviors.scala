/**
 * Ordered Field Behaviors
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra

import org.scalatest.FlatSpec

/**
 * Ordered Field Behaviors
 */
trait OrderedFieldBehaviors extends OrderedBehaviors with FieldBehaviors { this: FlatSpec =>
  def orderedFieldAxioms[F](a: F, b: F, c: F)(implicit ev: OrderedField[F]) {
    it should behave like fieldAxioms(a, b, c)
    it should behave like orderedAxioms(a, b, c)
  }
}
