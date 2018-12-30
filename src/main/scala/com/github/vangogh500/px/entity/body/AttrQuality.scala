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
  trait Scalar extends AttrQuality
  trait Vector extends AttrQuality
  case object Mass extends Scalar
  case object Displacement extends Vector
}
