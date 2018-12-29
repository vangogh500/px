/**
 * V2 Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

import org.scalatest.FlatSpec

class VSpec extends FlatSpec {
  "V" should "negate" in {
    val v0 = V(0, 0)
    assert(-v0 == v0)
    val u1 = V(0, 1.0, 0)
    assert(-u1 == V(0, -1, 0))
  }
  it should "add" in {
    val v1 = V(1, 2)
    val v2 = V(3, 2)
    val v3 = V(1, 2, 3)
    val v4 = V(3, 2, 1)
    assert(v1 + v2 == V(4, 4))
    assert(v3 + v4 == V(4, 4, 4))
  }
  it should "subtract" in {
    val v1 = V(1, 2)
    val v2 = V(3, 2)
    val v3 = V(1, 2, 3)
    val v4 = V(3, 2, 1)
    assert(v1 - v2 == V(-2, 0))
    assert(v2 - v1 == V(2, 0))
    assert(v3 - v4 == V(-2, 0, 2))
    assert(v4 - v3 == V(2, 0, -2))
  }
  it should "multiply with a scalar" in {
    val v1 = V2(1, 2)
    val v2 = V3(3.5, 2.0, 1.0)
    assert(v1 * 2 == V2(2,4))
    assert(v2 * 1 == V3(3.5, 2.0, 1.0))
  }
}
