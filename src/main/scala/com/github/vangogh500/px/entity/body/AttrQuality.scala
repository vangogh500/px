/**
 * Attribute type
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body

/**
 * Attribute type
 */
trait AttrQuality

/**
 * Attribute type
 */
object AttrQuality {
  /**
   * Scalar attribute type
   */
  trait Scalar extends AttrQuality
  /**
   * Vector attribute type
   */
  trait Vector extends AttrQuality
  /**
   * Scalar attribute type
   */
  object Scalar {
    /**
     *
     */
    case object Mass extends Scalar
  }
  /**
   * Vector attribute type
   */
  object Vector {
    case object Displacement extends Vector
  }
}
