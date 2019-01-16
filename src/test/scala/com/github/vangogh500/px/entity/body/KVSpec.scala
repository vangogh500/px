/**
 * KV Specs
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body

import math.algebra.{VSpaceBehaviors}
import org.scalatest.FlatSpec

/**
 * Spec for KV
 */
class KVSpec extends FlatSpec with VSpaceBehaviors {
  "VectorSpace[Double,KV]" should behave like vSpaceAxioms(KV(1.0, 3.50), KV(0.25), KV(0.50, 9.00, 3.25), 4.50, 6.50)
  "VectorSpace[Double,(KV, KV)]" should behave like vSpaceAxioms(
    (KV(1.0, 3.50), KV(2.5)),
    (KV(0.25), KV()),
    (KV(0.50, 9.00, 3.25), KV(0.25, 0.5)),
    4.50, 6.50)
  "VectorSpace[Double,(KV, KV, KV)]" should behave like vSpaceAxioms(
    (KV(), KV(), KV()),
    (KV(0.25), KV(), KV(1.0)),
    (KV(0.50, 9.00, 3.25), KV(0.25, 0.5), KV(0.0, 3.25)),
    4.50, 6.50)
  "KV" should "be correctly applied" in {
    val a = KV(1.0, 2.0, 3.0)
    assert(a.timeReduce(4) == KV(1 + 2 * 4 + 16 * 1.5, 2 + 12, 3))
    assert(a.timeReduce(6.5) == KV(1 + 13 + (Math.pow(6.5,2) * 3 / 2), 2 + 3 * 6.5, 3.0))
  }
  "(KV, KV)" should "be correctly applied" in {
    val x = KV(1.0, 2.0, 3.0)
    val y = KV(3.0, 2.0, 1.0)
    assert((x, y).timeReduce(4) == (KV(1 + 2 * 4 + 16 * 1.5, 2 + 12, 3), KV(3 + 2 * 4 + 8, 6, 1)))
  }
}
