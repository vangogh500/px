/**
 * Attribute quantity
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body
package attribute

import math.Vec

trait AttrQuantity[Repr <: AttrQuantity[Repr]] extends TimeReducable[Repr]

case class ScalarQuantity(vector: Vec[Double,Double]) extends AttrQuantity[ScalarQuantity] {
  def timeReduce(dt: Double): ScalarQuantity = ScalarQuantity(vector match {
    case Vec(x) => Vec(x)
    case Vec(x, y) => Vec(x + (y * dt), y)
    case Vec(x, y, z) => Vec(x + (dt * y) + (0.5 * z * Math.pow(dt, 2)), y + (dt * z), z)
  })
}

case class VectorQuantity(vector: Vec[Double, Vec[Double, Double]]) extends AttrQuantity[VectorQuantity] {
  def timeReduce(dt: Double): VectorQuantity = VectorQuantity(vector match {
    case Vec(x) => Vec(x)
    case Vec(x, y) => Vec(x + (y * dt), y)
    case Vec(x, y, z) => Vec(x + (y * dt) + (z * 0.5 * Math.pow(dt, 2)), y + (z * dt), z)
  })
}
