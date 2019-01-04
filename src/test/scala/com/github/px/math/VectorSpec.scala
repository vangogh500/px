/**
 * Vector Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

import implicits._
import org.scalatest.FlatSpec

class VectorSpec extends FlatSpec {
  implicit val ev = Vector.vectorSpace[Double]
  "Vector" should "negate" in {
    val v0 = Vector(0)
    val v1 = Vector(0, 1)
    val v2 = Vector(1, 2, 3)
    assert(-v0 == v0)
    assert(-v1 == Vector(0, -1))
    assert(-v2 == Vector(-1, -2, -3))
  }
  it should "add" in {
    val v0 = Vector(0)
    val v1 = Vector(0, 0)
    val v2 = Vector(1, 2, 3)
    assert(v0 + v1 == v1)
    assert(v0 + v2 == v2)
    assert(v1 + v2 == Vector(1, 2, 3))
  }
  it should "subtract" in {
    val v0 = Vector(0)
    val v1 = Vector(0, 1)
    val v2 = Vector(1, 2, 3)
    assert(v1 - v0 == v1)
    assert(v2 - v0 == v2)
    assert(v0 - v1 == -v1)
    assert(v0 - v2 == -v2)
    assert(v2 - v1 == Vector(1, 1, 3))
    assert(v1 - v2 == Vector(-1, -1, -3))
  }
  it should "multiply with a scalar" in {
    val v0 = Vector(0)
    val v1 = Vector(0, 1)
    val v2 = Vector(1, 2, 3)
    assert(v0 * 99 == v0)
    assert(v1 * 2 == Vector(0, 2))
    assert(v2 * 1 == Vector(1, 2, 3))
  }
  it should "unapply" in {
    val v0 = Vector(0)
    val v1 = Vector(0, 1)
    val v2 = Vector(1, 2, 3)
    assert(v0 match {
      case Vector(x) => x == 0
      case _ => false
    })
    assert(v1 match {
      case Vector(x, y) => Seq(x,y) == Seq(0, 1)
      case _ => false
    })
    assert(v2 match {
      case Vector(x, y, z) => Seq(x,y,z) == Seq(1,2,3)
      case _ => false
    })
  }
}
