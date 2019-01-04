/**
 * Implicits
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra

package object implicits {
  implicit class FieldElement[F](a: F)(implicit ev: Field[F]) {
    def unary_- : F = ev.negate(a)
    def reciprocal: F = ev.reciprocate(a)
    def +(b: F): F = ev.plus(a, b)
    def -(b: F): F = ev.minus(a, b)
    def *(b: F): F = ev.times(a, b)
    def /(b: F): F = ev.div(a, b)
  }
  implicit class VectorSpaceVector[F,V](v: V)(implicit ev: VectorSpace[F, V]) {
    def unary_- : V = ev.negate(v)
    def +(u: V): V = ev.plus(v, u)
    def -(u: V): V = ev.minus(v, u)
    def *(c: F): V = ev.stimes(c, v)
  }
  implicit class VectorSpaceFieldElement1[F,V](a: F)(implicit ev: VectorSpace[F, V]) {
    def *(v: V): V = ev.stimes(a,v)
  }
}
