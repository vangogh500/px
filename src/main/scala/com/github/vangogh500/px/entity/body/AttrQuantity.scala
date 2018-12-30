/**
 * Attribute quantity
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body

import math.{Vec, Vec1, Vec2, Vec3}

/**
 * Attribute quantity
 * @tparam T Vector type of vector
 * @param v Vector representing the magnitude/direction of the attribute
 */
case class AttrQuantity[T](v: Vec[Double, T]) extends TimeReducable[AttrQuantity[T]] {
  def timeReduce(dt: Double): AttrQuantity[T] = {
    implicit val ev = v.ev
    v match {
      case Vec(x) => AttrQuantity(Vec(x))
      case Vec(x, y) => AttrQuantity(Vec(ev.plus(x, ev.stimes(dt,y)), y))
      case Vec(x, y, z) => AttrQuantity(Vec(
        ev.plus(ev.plus(x, ev.stimes(dt, y)), ev.stimes(Math.pow(dt, 2) * 0.5, z)),
        ev.plus(y, ev.stimes(dt, z)),
        z
      ))
    }
  }
}
