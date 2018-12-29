/**
 * V2 Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

import org.scalatest.FlatSpec

class V2Spec extends FlatSpec {
  "V2" should "negate" in {
    val v0 = V2(0, 0)
    assert(-v0 == v0)
    val u1 = V2(0, 1.0)
    assert(-u1 == V2(0, -1))
    val r1 = V2(5, -2)
    assert(-r1 == V2(-5, 2.0))
  }
  it should "add" in {
    val v1 = V2(1, 2)
    val v2 = V2(3, 2)
    val v0 = V2(0, 0)
    assert(v1 + v2 == V2(4, 4))
    assert(v2 + v0 == v2)
    assert(v1 + v0 == v1)
    assert(v0 + v0 == v0)
  }
  it should "subtract" in {
    val v1 = V2(1, 2)
    val v2 = V2(3, 2)
    val v0 = V2(0, 0)
    assert(v1 - v2 == V2(-2, 0))
    assert(v2 - v1 == V2(2, 0))
    assert(v0 - v1 == -v1)
    assert(v0 - v2 == -v2)
    assert(v1 - v0 == v1)
    assert(v2 - v0 == v2)
  }
  it should "multiply with a scalar" in {
    val v1 = V2(1, 2)
    val v2 = V2(3.5, 2.0)
    val v0 = V2(0, 0)
    assert(v1 * 2 == V2(2,4))
    assert(v2 * 1 == V2(3.5, 2.0))
    assert(v0 * 52 == v0)
  }
}
