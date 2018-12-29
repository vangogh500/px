/**
 * A1 Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body
package attribute
package com.github.vangogh500

import math.V3
import org.scalatest.FlatSpec

class A1Spec extends FlatSpec {
  "A1" should "timeReduce" in {
    val aInt = A1(10)
    val aDouble = A1(12.6)
    val aVec3 = A1(V3(1, 2, 3))
    assert(aInt.timeReduce(12) == aInt)
    assert(aDouble.timeReduce(6) == aDouble)
    assert(aVec3.timeReduce(0) == aVec3)
  }
}
