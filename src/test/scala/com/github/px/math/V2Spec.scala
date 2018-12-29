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
  "doubleintVec2Space" should "produce a correct zero vector" in {
    val space = implicitly[VectorSpace[Double, V2[Int]]]
    assert(space.zero == V2(0, 0))
  }
  it should "negate vectors" in {
    val space = implicitly[VectorSpace[Double, V2[Int]]]
    assert(space.negate(V2(1,0)) == V2(-1,0))
    assert(space.negate(V2(-2,3)) == V2(2,-3))
  }
  it should "add vectors" in {
    val space = implicitly[VectorSpace[Double, V2[Int]]]
    assert(space.plus(V2(1,0), V2(0,1)) == V2(1,1))
    assert(space.plus(V2(1,-2), V2(2,1)) == V2(3,-1))
  }
  it should "multiply with a scalar" in {
    val space = implicitly[VectorSpace[Double, V2[Int]]]
    assert(space.stimes(2.0, V2(0,3)) == V2(0,6))
    assert(space.stimes(2.5, V2(-1,5)) == V2(-2,10))
  }
  "doubledoubleVec2Space"  should "produce a correct zero vector" in {
    val space = implicitly[VectorSpace[Double, V2[Double]]]
    assert(space.zero == V2(0.0, 0.0))
  }
  it should "negate vectors" in {
    val space = implicitly[VectorSpace[Double, V2[Double]]]
    assert(space.negate(V2(1.2,0.0)) == V2(-1.2,0))
    assert(space.negate(V2(-2.01,3.5)) == V2(2.01,-3.5))
  }
  it should "add vectors" in {
    val space = implicitly[VectorSpace[Double, V2[Double]]]
    assert(space.plus(V2(1.91,0.0), V2(0.0,1.19)) == V2(1.91,1.19))
    assert(space.plus(V2(1.0,-2.0), V2(2.0,1.0)) == V2(3.0,-1.0))
  }
  it should "multiply with a scalar" in {
    val space = implicitly[VectorSpace[Double, V2[Double]]]
    assert(space.stimes(2.0, V2(0.0,3.0)) == V2(0.0,6.0))
    assert(space.stimes(2.5, V2(-1.0,5.0)) == V2(-2.5,12.5))
  }
}
