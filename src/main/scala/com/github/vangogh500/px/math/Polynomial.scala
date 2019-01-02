/**
 * Polynomial
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math

/**
 * Polynomial
 * @tparam F scalar type
 * @tparam V vector type
 */
case class Polynomial[F,V](args: V*)(implicit ev: VectorSpace[F,V]) extends 
