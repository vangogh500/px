/**
 * V3 Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

import org.scalatest.FlatSpec

class VectorSpaceSpec extends FlatSpec {
  "doubleintSpace" should "produce a correct zero vector" in {
    val space = implicitly[VectorSpace[Double, Int]]
    assert(space.zero == 0)
  }
  it should "negate vectors" in {
    val space = implicitly[VectorSpace[Double, Int]]
    assert(space.negate(21) == -21)
    assert(space.negate(-1) == 1)
    assert(space.negate(0) == 0)
  }
  it should "add vectors" in {
    val space = implicitly[VectorSpace[Double, Int]]
    assert(space.plus(1, 2) == 3)
    assert(space.plus(6, -6) == 0)
  }
  it should "multiply with a scalar" in {
    val space = implicitly[VectorSpace[Double, Int]]
    assert(space.stimes(2.0, 1) == 2)
    assert(space.stimes(-3.2, 1) == -3)
  }
  "doubledoubleSpace" should "produce a correct zero vector" in {
    val space = implicitly[VectorSpace[Double, Double]]
    assert(space.zero == 0.0)
  }
  it should "negate vectors" in {
    val space = implicitly[VectorSpace[Double, Double]]
    assert(space.negate(21.2) == -21.2)
    assert(space.negate(-1.01) == 1.01)
    assert(space.negate(0.0) == 0.0)
  }
  it should "add vectors" in {
    val space = implicitly[VectorSpace[Double, Double]]
    assert(space.plus(1.011, 2.43) == 3.441)
    assert(space.plus(6.2, -6.2) == 0.0)
  }
  it should "multiply with a scalar" in {
    val space = implicitly[VectorSpace[Double, Double]]
    assert(space.stimes(2.0, 1.2) == 2.4)
    assert(space.stimes(-3.2, 1.0) == -3.2)
  }
}
