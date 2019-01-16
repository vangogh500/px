/**
 * Attr
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body

import math.algebra.VSpace

/**
 * Attr
 */
trait Attr

/**
 * Attr
 */
object Attr {
  /**
   * Mass
   */
  case object Mass extends Attr
  /**
   * Displacement
   */
  case object Displacement extends Attr

  implicit class AttrBuilder(attr: Attr) {
    def :=(x: KV): (Attr, KV) = attr -> x
    def :=(x: KV, y: KV): (Attr, (KV, KV)) = Mass -> (x, y)
    def :=(x: KV, y: KV, z: KV): (Attr, (KV, KV, KV)) = Mass -> (x, y, z)
  }
}
