/**
 * A3 Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body
package attribute
package com.github.vangogh500

import math.V3
import org.scalatest.FlatSpec

class A3Spec extends FlatSpec {
  "A3" should "timeReduce" in {
    val aInt = A3(3, 2, 1)
    val aDouble = A3(1.0, 2.0, 1.0)
    val aVec3 = A3(V3(1, 0, 0), V3(0, 1, 0), V3(0, 0, 1))
    assert(aInt.timeReduce(4) == A3(19, 6, 1))
    assert(aDouble.timeReduce(3) == A3(11.5, 5.0, 1.0))
    assert(aVec3.timeReduce(4) == A3(V3(1, 4, 8), V3(0, 1, 4), V3(0,0,1)))
  }
}
