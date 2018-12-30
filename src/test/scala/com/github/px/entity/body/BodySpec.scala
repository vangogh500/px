/**
 * Body Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body

import math.Vec
import org.scalatest.FlatSpec

class BodySpec extends FlatSpec {
  "Body" should "timeReduce" in {
    val b0 = Body(Map(
      AttrQuality.Scalar.Mass -> AttrQuantity(Vec(10))
    ), Map(
      AttrQuality.Vector.Displacement -> AttrQuantity(Vec(Vec(1.0,2.0,3.0), Vec(1.0,1.0,1.0), Vec(1.0,0.0,0.0)))
    ))
    assert(b0.timeReduce(1.0) == Body(Map(
      AttrQuality.Scalar.Mass -> AttrQuantity(Vec(10))
    ), Map(
      AttrQuality.Vector.Displacement -> AttrQuantity(Vec(Vec(2.5,3.0,4.0), Vec(2.0,1.0,1.0), Vec(1.0,0.0,0.0)))
    )))
  }
}
