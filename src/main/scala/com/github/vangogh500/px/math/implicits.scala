/**
 * Implicits
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

package object implicits {
  implicit class FieldElement[F](c1: F)(implicit ev: Field[F]) {
    def unary_- : F = ev.negate(c1)
    def +(c2: F): F = ev.plus(c1, c2)
    def -(c2: F): F = ev.minus(c1, c2)
    def *(c2: F): F = ev.times(c1, c2)
    def /(c2: F): F = ev.div(c1, c2)
  }
  implicit class VectorSpaceVector[F,V](v1: V)(implicit ev: VectorSpace[F, V]) {
    def unary_- : V = ev.negate(v1)
    def +(v2: V): V = ev.plus(v1, v2)
    def -(v2: V): V = ev.minus(v1, v2)
    def *(c: F): V = ev.stimes(c, v1)
  }
}
