/**
 * Field Behaviors
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

import implicits._
import org.scalatest.FlatSpec

/**
 * Field Behaviors
 */
trait FieldBehaviors { this: FlatSpec =>
  def axioms[F](a: F, b: F, c: F)(implicit ev: Field[F]) {
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
    it should "have additive inverse" in {
      assert(a + -a == ev.zero)
      assert(b + -b == ev.zero)
      assert(c + -c == ev.zero)
    }
    it should "have distributive addition and multiplication" in {
      assert(a * (b + c) == (a * b) + (a * c))
      assert(b * (a + c) == (b * a) + (b * c))
      assert(c * (a + b) == (c * a) + (c * b))
    }
  }
}
