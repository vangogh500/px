/**
 * Attribute tag
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body
package attribute

import math.Vec

/**
 * Attribute tag
 */
trait AttrTag

/**
 * Scalar attribute tag
 * @param attribute Attribute of tag
 * @param quantity Quantity of tag
 */
case class ScalarAttrTag(attribute: ScalarAttr, quantity: Vec[Double,Double]) extends AttrTag
/**
 * Vector attribute tag
 * @param attribute Attribute of tag
 * @param quantity Quantity of tag
 */
case class VectorAttrTag(attribute: VectorAttr, quantity: Vec[Double,Vec[Double, Double]]) extends AttrTag
