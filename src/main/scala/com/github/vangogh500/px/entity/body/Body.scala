/**
 * Body
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body

import math.Vec
import attribute.{AttrTag, ScalarAttrTag, VectorAttrTag, ScalarAttr, VectorAttr}

case class Body(
  scalar: Map[ScalarAttr, Vec[Double, Double]],
  vector: Map[VectorAttr, Vec[Double, Vec[Double, Double]]]
)

object Body {
  def apply(attrs: AttrTag*): Body = Body(
    attrs.collect {
      case ScalarAttrTag(a, q) => a -> q
    }.toMap,
    attrs.collect {
      case VectorAttrTag(a, q) => a -> q
    }.toMap
  )
}
