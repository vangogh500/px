/**
 * Vector Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra

import implicits._
import org.scalatest.FlatSpec

class VectorSpec extends FlatSpec with VectorSpaceBehaviors {
  "Vector" should "unapply" in {
    val v0 = Vector(0)
    val v1 = Vector(0, 1)
    val v2 = Vector(1, 2, 3)
    assert(v0 match {
      case Vector(x) =>
        x == 0.0
      case _ =>
        println(v0)
        false
    })
    assert(v1 match {
      case Vector(x, y) => Seq(x,y) == Seq(0, 1)
      case _ => false
    })
    assert(v2 match {
      case Vector(x, y, z) => Seq(x,y,z) == Seq(1,2,3)
      case _ => false
    })
  }
  it should behave like axioms(Vector(1.0, 3.50, 0.0), Vector(0.25, 0.50, 0.25), Vector(0.50, 9.00, 13.50), 4.50, 6.50)
}
