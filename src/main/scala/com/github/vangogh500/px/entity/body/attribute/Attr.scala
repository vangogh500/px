/**
 * Attribute
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body
package attribute

import math.Vec

/**
 * Attribute
 * @tparam Q The type of the quantity associated with attribute
 */
sealed trait Attr[Q] {
  /**
   * Create a AttrTag by associating attribute with a quantity
   */
  def :=(quantity: Vec[Double,Q]): AttrTag
}

/**
 * Scalar attribute
 */
sealed trait ScalarAttr extends Attr[Double]
/**
 * Vector attribute
 */
sealed trait VectorAttr extends Attr[Vec[Double, Double]]

/**
 * Attribute
 */
object Attr {
  /**
   * Mass attribute
   */
  case object Mass extends ScalarAttr {
    def :=(quantity: Vec[Double, Double]): AttrTag = ScalarAttrTag(Mass, quantity)
  }
  /**
   * Displacement attribute
   */
  case object Displacement extends VectorAttr {
    def :=(quantity: Vec[Double, Vec[Double, Double]]): AttrTag = VectorAttrTag(Displacement, quantity)
  }
}
