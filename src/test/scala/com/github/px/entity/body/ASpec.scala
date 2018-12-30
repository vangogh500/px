/**
 * A Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body

import math.V
import org.scalatest.FlatSpec

class ASpec extends FlatSpec {
  "A" should "timeReduce" in {
    val aInt = A(10)
    val aDouble = A(1.6, 2.5)
    val aVec3 = A(V(1.0,2.0,3.0), V(1.0,1.0,1.0), V(1.0,0.0,0.0))
    assert(aInt.timeReduce(12) == aInt)
    assert(aDouble.timeReduce(6) == A(16.6, 2.5))
    assert(aVec3.timeReduce(1.0) == A(V(2.5,3.0,4.0), V(2.0,1.0,1.0), V(1.0,0.0,0.0)))
  }
}
