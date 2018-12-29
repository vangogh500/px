/**
 * A2 Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body
package attribute
package com.github.vangogh500

import math.V3
import org.scalatest.FlatSpec

class A2Spec extends FlatSpec {
  "A2" should "timeReduce" in {
    val aInt = A2(10, 2)
    val aDouble = A2(12.6, 1.1)
    val aVec3 = A2(V3(1, 2, 3), V3(1, 2, 3))
    assert(aInt.timeReduce(10) == A2(30, 2))
    assert(aDouble.timeReduce(2) == A2(14.8, 1.1))
    assert(aVec3.timeReduce(3) == A2(V3(4, 8, 12), V3(1, 2, 3)))
  }
}
