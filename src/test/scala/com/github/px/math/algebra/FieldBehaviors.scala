/**
 * Field Behaviors
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra

import org.scalatest.FlatSpec

/**
 * Field Behaviors
 */
trait FieldBehaviors { this: FlatSpec =>
  def fieldAxioms[F](a: F, b: F, c: F)(implicit ev: Field[F]) {
    import ev._
    it should "have associative and communative addition" in {
      assert((a + b) + c == a + (b + c))
      assert((a + c) + b == a + (c + b))
      assert((b + a) + c == b + (a + c))
    }
    it should "have associative and communative multiplication" in {
      assert((a * b) * c == a * (b * c))
      assert((a * c) * b == a * (c * b))
      assert((b * a) * c == b * (a * c))
    }
    it should "have additive identity" in {
      assert(ev.zero + a == a)
      assert(ev.zero + b == b)
      assert(ev.zero + c == c)
    }
    it should "have multiplicative identity" in {
      assert(ev.one * a == a)
      assert(ev.one * b == b)
      assert(ev.one * c == c)
    }
    it should "have additive inverse" in {
      assert(a + -a == ev.zero)
      assert(b + -b == ev.zero)
      assert(c + -c == ev.zero)
    }
    it should "have multiplicative inverse" in {
      assert(a * a.reciprocal == ev.one)
      assert(b * b.reciprocal == ev.one)
      assert(c * c.reciprocal == ev.one)
    }
    it should "have distributive addition and multiplication" in {
      assert(a * (b + c) == (a * b) + (a * c))
      assert(b * (a + c) == (b * a) + (b * c))
      assert(c * (a + b) == (c * a) + (c * b))
    }
    it should "pow correctly" in {
      assert(ev.one == a ** 0)
      assert(ev.one == b ** 0)
      assert(ev.one == c ** 0)
      assert(ev.one == a ** 0)
      assert(a * a * a == a ** 3)
      assert(b.reciprocal * b.reciprocal * b.reciprocal == b ** -3)
      assert(c == c ** 1)
    }
  }
}
