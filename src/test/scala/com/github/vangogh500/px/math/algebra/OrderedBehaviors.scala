/**
 * Ordered Behaviors
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra

import org.scalatest.FlatSpec

/**
 * Ordered Behaviors
 */
trait OrderedBehaviors { this: FlatSpec =>
  def orderedAxioms[F](a: F, b: F, c: F)(implicit ev: Ordering[F]) {
    import ev._
    it should "display antisymmetry (leq)" in {
      assert(!(a <= b && b <= a) || a == b)
      assert(!(a <= c && c <= a) || a == c)
      assert(!(c <= b && c <= b) || c == b)
    }
    it should "display antisymmetry (geq)" in {
      assert(!(a >= b && b >= a) || a == b)
      assert(!(a >= c && c >= a) || a == c)
      assert(!(c >= b && b >= c) || c == b)
    }
    it should "display transitivity (leq)" in {
      assert(!(a <= b && b <= c) || a <= c)
      assert(!(c <= b && b <= a) || c <= a)
      assert(!(b <= c && b <= a) || b <= a)
      assert(!(a <= c && c <= b) || a <= b)
      assert(!(c <= a && a <= b) || c <= b)
      assert(!(b <= a && a <= c) || b <= c)
    }
    it should "display transitivity (geq)" in {
      assert(!(a >= b && b >= c) || a >= c)
      assert(!(c >= b && b >= a) || c >= a)
      assert(!(b >= c && b >= a) || b >= a)
      assert(!(a >= c && c >= b) || a >= b)
      assert(!(c >= a && a >= b) || c >= b)
      assert(!(b >= a && a >= c) || b >= c)
    }
    it should "display transitivity (lt)" in {
      assert(!(a < b && b < c) || a < c)
      assert(!(c < b && b < a) || c < a)
      assert(!(b < c && b < a) || b < a)
      assert(!(a < c && c < b) || a < b)
      assert(!(c < a && a < b) || c < b)
      assert(!(b < a && a < c) || b < c)
    }
    it should "display transitivity (gt)" in {
      assert(!(a > b && b > c) || a > c)
      assert(!(c > b && b > a) || c > a)
      assert(!(b > c && b > a) || b > a)
      assert(!(a > c && c > b) || a > b)
      assert(!(c > a && a > b) || c > b)
      assert(!(b > a && a > c) || b > c)
    }
    it should "display transitivity (eq)" in {
      assert(!(a == b && b == c) || a == c)
      assert(!(c == b && b == a) || c == a)
      assert(!(b == c && b == a) || b == a)
      assert(!(a == c && c == b) || a == b)
      assert(!(c == a && a == b) || c == b)
      assert(!(b == a && a == c) || b == c)
    }
    it should "display connex property (leq)" in {
      assert(a <= b || b <= a)
      assert(a <= c || c <= a)
      assert(c <= b || b <= c)
    }
    it should "display connex property (geq)" in {
      assert(a >= b || b >= a)
      assert(a >= c || c >= a)
      assert(c >= b || c >= b)
    }
    it should "display strict total order (lt, eq)" in {
      assert(!(a < b) || (a <= b && a != b))
      assert(!(a < c) || (a <= c && a != c))
      assert(!(b < c) || (b <= c && b != c))
      assert(!(c < b) || (c <= b && c != b))
    }
    it should "display strict total order (gt, eq)" in {
      assert(!(a > b) || (a >= b && a != b))
      assert(!(a > c) || (a >= c && a != c))
      assert(!(b > c) || (b >= c && b != c))
      assert(!(c > b) || (c >= b && c != b))
    }
  }
}
