/**
 * EV Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra

import org.scalatest.FlatSpec

class EVSpec extends FlatSpec with VectorSpaceBehaviors {
  "EV" should "unapply" in {
    val v0 = EV(0)
    val v1 = EV(0, 1)
    val v2 = EV(1, 2, 3)
    assert(v0 match {
      case EV(x) =>
        x == 0.0
      case _ =>
        println(v0)
        false
    })
    assert(v1 match {
      case EV(x, y) => Seq(x,y) == Seq(0, 1)
      case _ => false
    })
    assert(v2 match {
      case EV(x, y, z) => Seq(x,y,z) == Seq(1,2,3)
      case _ => false
    })
  }
  it should behave like vectorSpaceAxioms(EV(1.0, 3.50, 0.0), EV(0.25, 0.50, 0.25), EV(0.50, 9.00, 13.50), 4.50, 6.50)
}
