/**
 * Kinematic value
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity
package body

import math.algebra.{VSpace, Field, Algo, Poly}

/**
 * Kinematic value
 * @constructor
 * @param coeffs Coefficients defining the n-th order derivative
 */
case class KV(coeffs: Double*) {
  /**
   * Custom equality
   */
  override def equals(that: Any): Boolean = that match {
    case KV(coeffs2 @ _*) => coeffs.zipAll(coeffs2, 0, 0).forall {
      case (a, b) => a == b
    }
  }
}

/**
 * Kinematic value
 */
object KV {
  /**
   * Vector space for Kinematic values
   */
  implicit object vspace extends VSpace[Double, KV] {
    def field: Field[Double] = Field.Double
    def zero: KV = KV()
    def negate(v: KV): KV = v match {
      case KV(coeffs @ _*) => KV(coeffs.map(field.negate(_)): _*)
    }
    def plus(v: KV, u: KV): KV = (v, u) match {
      case (KV(vc @ _*), KV(uc @ _*)) =>
        KV(vc.zipAll(uc, field.zero, field.zero).map {
          case (a, b) => field.plus(a, b)
        }: _*)
    }
    def stimes(c: Double, v: KV): KV = v match {
      case KV(coeffs @ _*) => KV(coeffs.map(field.times(c,_)): _*)
    }
  }
  implicit object TR extends TimeReducable[KV] {
    def timeReduce(dt: Double, entity: KV): KV = {
      def reduceCoeffs(sq: Seq[Double]): Seq[Double] = sq match {
        case Seq() => Seq()
        case head +: tail =>
          val f = Poly(sq.zipWithIndex.map {
            case (c, i) => c / Algo.factorial(i).toDouble
          }: _*)
          f(dt) +: reduceCoeffs(tail)
      }
      KV(reduceCoeffs(entity.coeffs): _*)
    }
  }
  implicit object TR2 extends TimeReducable[(KV, KV)] {
    def timeReduce(dt: Double, entity: (KV, KV)): (KV, KV) = entity match {
      case (x, y) => (TR.timeReduce(dt, x), TR.timeReduce(dt, y))
    }
  }
  implicit object TR3 extends TimeReducable[(KV, KV, KV)] {
    def timeReduce(dt: Double, entity: (KV, KV, KV)): (KV, KV, KV) = entity match {
      case (x, y, z) => (TR.timeReduce(dt, x), TR.timeReduce(dt, y), TR.timeReduce(dt, z))
    }
  }
}
