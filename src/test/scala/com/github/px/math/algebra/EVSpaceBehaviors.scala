/**
 * Euclidean Vector Space Behaviors
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra

import org.scalatest.FlatSpec

/**
 * Euclidean Vector Space Behaviors
 */
trait EVSpaceBehaviors { this: FlatSpec =>
  def evSpaceAxioms[F,V](v: V, u: V, w: V, a: F, b: F)(implicit ev: EVSpace[F,V]) {
    import ev._
    it should "have associative and communative addition" in {
      assert((v + u) + w == v + (u + w))
      assert((v + w) + u == v + (w + u))
      assert((u + v) + w == u + (v + w))
    }
    it should "have additive identity" in {
      assert(ev.zero + v == v)
      assert(ev.zero + u == u)
      assert(ev.zero + w == w)
    }
    it should "have additive inverse" in {
      assert(v + -v == ev.zero)
      assert(u + -u == ev.zero)
      assert(w + -w == ev.zero)
    }
    it should "support scalar and field multiplication" in {
      assert(a * (b * v) == (a * b) * v)
      assert(a * (b * u) == (a * b) * u)
      assert(a * (b * w) == (a * b) * w)
    }
    it should "support the identity element of scalar multiplication" in {
      assert(ev.field.one * v == v)
      assert(ev.field.one * u == u)
      assert(ev.field.one * w == w)
    }
    it should "display distributivity of scalar multiplication with respect to vector addition" in {
      assert(a * (u + v) == (a * u) + (a * v))
      assert(b * (u + v) == (b * u) + (b * v))
      assert(a * (w + v) == (a * w) + (a * v))
      assert(b * (w + v) == (b * w) + (b * v))
      assert(a * (u + w) == (a * u) + (a * w))
      assert(b * (u + w) == (b * u) + (b * w))
    }
    it should "display distributivity of scalar multiplication with respect to field addition" in {
      assert(v * (a + b) == (a * v) + (b * v))
      assert(u * (a + b) == (a * u) + (b * u))
      assert(w * (a + b) == (a * w) + (b * w))
    }
  }
}
