/**
 * V3 Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

import org.scalatest.FlatSpec

class V3Spec extends FlatSpec {
  "V3" should "negate" in {
    val v0 = V3(0, 0, 0)
    assert(-v0 == v0)
    val u1 = V3(0, 1.0, 0)
    assert(-u1 == V3(0, -1, 0))
    val r1 = V3(5, -2, 9)
    assert(-r1 == V3(-5, 2.0, -9))
  }
  it should "add" in {
    val v1 = V3(1, 2, 3)
    val v2 = V3(3, 2, 1)
    val v0 = V3(0, 0, 0)
    assert(v1 + v2 == V3(4, 4, 4))
    assert(v2 + v0 == v2)
    assert(v1 + v0 == v1)
    assert(v0 + v0 == v0)
  }
  it should "subtract" in {
    val v1 = V3(1, 2, 3)
    val v2 = V3(3, 2, 1)
    val v0 = V3(0, 0, 0)
    assert(v1 - v2 == V3(-2, 0, 2))
    assert(v2 - v1 == V3(2, 0, -2))
    assert(v0 - v1 == -v1)
    assert(v0 - v2 == -v2)
    assert(v1 - v0 == v1)
    assert(v2 - v0 == v2)
  }
  it should "multiply with a scalar" in {
    val v1 = V3(1, 2, 3)
    val v2 = V3(3.5, 2.0, 1.0)
    val v0 = V3(0, 0, 0)
    assert(v1 * 2 == V3(2,4,6))
    assert(v2 * 1 == V3(3.5, 2.0, 1.0))
    assert(v0 * 52 == v0)
  }
  "doubleintVec3Space" should "produce a correct zero vector" in {
    val space = implicitly[VectorSpace[Double, V3[Int]]]
    assert(space.zero == V3(0, 0, 0))
  }
  it should "negate vectors" in {
    val space = implicitly[VectorSpace[Double, V3[Int]]]
    assert(space.negate(V3(1,0,0)) == V3(-1,0,0))
    assert(space.negate(V3(-2,3,1)) == V3(2,-3,-1))
  }
  it should "add vectors" in {
    val space = implicitly[VectorSpace[Double, V3[Int]]]
    assert(space.plus(V3(1,0,0), V3(0,1,1)) == V3(1,1,1))
    assert(space.plus(V3(1,-2,0), V3(2,1,3)) == V3(3,-1,3))
  }
  it should "multiply with a scalar" in {
    val space = implicitly[VectorSpace[Double, V3[Int]]]
    assert(space.stimes(2.0, V3(0,3,1)) == V3(0,6,2))
    assert(space.stimes(2.5, V3(-1,5,0)) == V3(-2,10,0))
  }
  "doubledoubleVec3Space" should "produce a correct zero vector" in {
    val space = implicitly[VectorSpace[Double, V3[Double]]]
    assert(space.zero == V3(0.0, 0.0, 0.0))
  }
  it should "negate vectors" in {
    val space = implicitly[VectorSpace[Double, V3[Double]]]
    assert(space.negate(V3(1.02,0.0,0.0)) == V3(-1.02,0.0,0.0))
    assert(space.negate(V3(-2.2,3.3,1.1)) == V3(2.2,-3.3,-1.1))
  }
  it should "add vectors" in {
    val space = implicitly[VectorSpace[Double, V3[Double]]]
    assert(space.plus(V3(1.001,0.0,0.0), V3(0.0,1.0,1.0)) == V3(1.001,1,1))
    assert(space.plus(V3(1.0,-2.21,0.1), V3(2.0,1.0,3.1)) == V3(3.0,-1.21,3.2))
  }
  it should "multiply with a scalar" in {
    val space = implicitly[VectorSpace[Double, V3[Double]]]
    assert(space.stimes(2.0, V3(0.0,3.1,1.0)) == V3(0.0,6.2,2.0))
    assert(space.stimes(2.5, V3(-1.0,5.0,0.0)) == V3(-2.5,12.5,0.0))
  }
}
