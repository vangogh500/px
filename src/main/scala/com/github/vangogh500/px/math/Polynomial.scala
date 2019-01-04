/**
 * Polynomial function
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

/**
 * Polynomial function
 * @see https://en.wikipedia.org/wiki/Polynomial
 * @tparam F scalar type
 * @tparam V vector type
 */
case class Polynomial[F,V](cons: V)(
  implicit vs: VectorSpace[F,V],
  num: Numeric[F]
) {
}
