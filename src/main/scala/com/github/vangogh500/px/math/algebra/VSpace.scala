/**
 * Euclidean Vector Space
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra

/**
 * Vector space
 * @see https://en.wikipedia.org/wiki/Euclidean_space
 * @tparam F Scalar type
 * @tparam V Vector type
 */
trait VSpace[F, V] extends Any {
  /**
   * Evidance that F is a scalar belonging to a field
   */
  def field: Field[F]
  /**
   * Zero vector
   */
  def zero: V
  /**
   * Negate a vector
   * @param v Vector to negate
   */
  def negate(v: V): V
  /**
   * Sums 2 vectors
   * @param v Vector to sum
   * @param u Vector to sum
   */
  def plus(v: V, u: V): V
  /**
   * Subtract 1 vector from another
   * @param v Vector to subtract from
   * @param u Vector to subtract with
   */
  def minus(v: V, u: V): V = plus(v, negate(u))
  /**
   * Multiplies a vector by a scalar
   * @param a Scalar to multiply
   * @param v Vector to multiply
   */
  def stimes(a: F, v: V): V
  /**
   * Rich ops wrapper for vectors
   * @param v vector
   */
  implicit class VectorOps(v: V) {
    /**
     * Negate
     */
    def unary_- : V = negate(v)
    /**
     * Add vector
     * @param u vector to add
     */
    def +(u: V): V = plus(v, u)
    /**
     * Subtract vector
     * @param u vector to subtract with
     */
    def -(u: V): V = minus(v, u)
    /**
     * Multiply by a scalar
     * @param c scalar to multiply with
     */
    def *(c: F): V = stimes(c, v)
  }
  /**
   * Rich ops wrapper for scalars
   * @param f scalar
   */
  implicit class FieldOps(a: F) {
    /**
     * Negate (additive inverse)
     */
    def unary_- : F = field.negate(a)
    /**
     * Reciprocal (multiplicative inverse)
     */
    def reciprocal: F = field.reciprocate(a)
    /**
     * Add scalar
     * @param b scalar to add
     */
    def +(b: F): F = field.plus(a, b)
    /**
     * Subtract scalar
     * @param b scalar to subtract with
     */
    def -(b: F): F = field.minus(a, b)
    /**
     * Multiply scalar
     * @param b scalar to multiply
     */
    def *(b: F): F = field.times(a, b)
    /**
     * Raise to an exponent
     * @param b exponent to raise to
     */
    def **(b: Int): F = field.pow(a, b)
    /**
     * Divide by scalar
     * @param b scalar to divide by
     */
    def /(b: F): F = field.div(a, b)
    /**
     * Multiply vector
     * @param v vector to multiply
     */
    def *(v: => V): V = stimes(a,v)
  }
}

/**
 * Vector space
 * @see https://en.wikipedia.org/wiki/Euclidean_space
 */
object VSpace {
  /**
   * Implicit conversion from a field to vector space
   */
  implicit def field[F](implicit ev: Field[F]): VSpace[F,F] = new VSpace[F, F] {
    def field: Field[F] = ev
    def zero: F = ev.zero
    def negate(v: F): F = ev.negate(v)
    def plus(v: F, u: F): F = ev.plus(v, u)
    def stimes(a: F, v: F): F = ev.times(a, v)
  }
  /**
   * Implicit vspace for tuple2s of vectors
   */
  implicit def tuple2[F,V](implicit ev: VSpace[F, V]): VSpace[F,(V,V)] = new VSpace[F,(V,V)] {
    def field: Field[F] = ev.field
    def zero: (V,V) = (ev.zero, ev.zero)
    def negate(v: (V,V)): (V,V) = v match {
      case (x, y) => (ev.negate(x), ev.negate(y))
    }
    def plus(v: (V,V), u: (V,V)): (V,V) = (v, u) match {
      case ((x1,y1), (x2,y2)) => (ev.plus(x1,x2), ev.plus(y1, y2))
    }
    def stimes(a: F, v: (V,V)): (V,V) = v match {
      case (x, y) => (ev.stimes(a, x), ev.stimes(a, y))
    }
  }
  /**
   * Implicit vspace for tuple3s of vectors
   */
  implicit def tuple3[F,V](implicit ev: VSpace[F, V]): VSpace[F,(V,V,V)] = new VSpace[F,(V,V,V)] {
    def field: Field[F] = ev.field
    def zero: (V,V,V) = (ev.zero, ev.zero, ev.zero)
    def negate(v: (V,V,V)): (V,V,V) = v match {
      case (x, y, z) => (ev.negate(x), ev.negate(y), ev.negate(z))
    }
    def plus(v: (V,V,V), u: (V,V,V)): (V,V,V) = (v, u) match {
      case ((x1,y1,z1), (x2,y2,z2)) => (ev.plus(x1, x2), ev.plus(y1, y2), ev.plus(z1, z2))
    }
    def stimes(a: F, v: (V,V,V)): (V,V,V) = v match {
      case (x, y, z) => (ev.stimes(a, x), ev.stimes(a, y), ev.stimes(a, z))
    }
  }
  /**
   * Implicit vspace for functions of fields
   */
  implicit def fieldFunc1[F](implicit ev: Field[F]): VSpace[F, F => F] = new VSpace[F, F => F] {
    def field: Field[F] = ev
    def zero: F => F = (_ => ev.zero)
    def negate(f: F => F): F => F = (x => ev.negate(f(x)))
    def plus(f: F => F, g: F => F): F => F = (x => f(x) + g(x))
    def stimes(a: F, f: F => F): F => F = (x => ev.times(a,f(x)))
  }
}
