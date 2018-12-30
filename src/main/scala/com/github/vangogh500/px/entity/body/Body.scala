/**
 * Body
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body

import math.Vec

/**
 * Body
 * @param sAttrs Set of scalar attributes
 * @param vAttrs Set of vector attributes
 */
case class Body(
  sAttrs: Map[AttrQuality.Scalar, AttrQuantity[Double]],
  vAttrs: Map[AttrQuality.Vector, AttrQuantity[Vec[Double,Double]]]
) extends TimeReducable[Body] {
  def timeReduce(dt: Double): Body = Body(
    sAttrs.mapValues(attr => attr.timeReduce(dt)),
    vAttrs.mapValues(attr => attr.timeReduce(dt))
  )
}
