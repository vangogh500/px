/**
 * AttrQuantity Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body

import math.Vec
import org.scalatest.FlatSpec

class AttrQuantitySpec extends FlatSpec {
  "AttrQuantity" should "timeReduce" in {
    val aInt = AttrQuantity(Vec(10))
    val aDouble = AttrQuantity(Vec(1.6, 2.5))
    val aVec3 = AttrQuantity(Vec[Double, Vec[Double, Double]](Vec(1.0,2.0,3.0), Vec(1.0,1.0,1.0), Vec(1.0,0.0,0.0)))
    assert(aInt.timeReduce(12) == aInt)
    assert(aDouble.timeReduce(6) == AttrQuantity(Vec(16.6, 2.5)))
    assert(aVec3.timeReduce(1.0) == AttrQuantity(Vec(Vec(2.5,3.0,4.0), Vec(2.0,1.0,1.0), Vec(1.0,0.0,0.0))))
  }
}
