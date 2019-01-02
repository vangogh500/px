/**
 * Vector Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

import org.scalatest.FlatSpec

class VectorSpec extends FlatSpec {
  "Vector" should "negate" in {
    val v0 = Vector[Double, Double](0.0)
    val v1 = Vector[Double, Double](0.0, 1.0)
    val v2 = Vector[Double, Double](1, 2, 3)
    assert(-v0 == v0)
    assert(-v1 == Vector[Double, Double](0.0, -1.0))
    assert(-v2 == Vector[Double, Double](-1, -2, -3))
  }
  it should "add" in {
    val v0 = Vector[Double, Double](0.0)
    val v1 = Vector[Double, Double](0.0, 1.0)
    val v2 = Vector[Double, Double](1, 2, 3)
    assert(v0 + v1 == v1)
    assert(v0 + v2 == v2)
    assert(v1 + v2 == Vector[Double, Double](1, 3, 3))
  }
  it should "subtract" in {
    val v0 = Vector[Double, Double](0.0)
    val v1 = Vector[Double, Double](0.0, 1.0)
    val v2 = Vector[Double, Double](1, 2, 3)
    assert(v1 - v0 == v1)
    assert(v2 - v0 == v2)
    assert(v0 - v1 == -v1)
    assert(v0 - v2 == -v2)
    assert(v2 - v1 == Vector[Double, Double](1, 1, 3))
    assert(v1 - v2 == Vector[Double, Double](-1, -1, -3))
  }
  it should "multiply with a scalar" in {
    val v0 = Vector[Double, Double](0.0)
    val v1 = Vector[Double, Double](0.0, 1.0)
    val v2 = Vector[Double, Double](1, 2, 3)
    assert(v0 * 99 == v0)
    assert(v1 * 2 == Vector[Double, Double](0.0, 2.0))
    assert(v2 * 1.5 == Vector[Double, Double](1.5, 3, 4.5))
  }
  it should "unapply" in {
    val v0 = Vector[Double, Double](0.0)
    val v1 = Vector[Double, Double](0.0, 1.0)
    val v2 = Vector[Double, Double](1, 2, 3)
    assert(v0 match {
      case Vector(x) => x == 0.0
      case _ => false
    })
    assert(v1 match {
      case Vector(x, y) => Seq(x,y) == Seq(0.0, 1.0)
      case _ => false
    })
    assert(v2 match {
      case Vector(x, y, z) => Seq(x,y,z) == Seq(1,2,3)
      case _ => false
    })
  }
}