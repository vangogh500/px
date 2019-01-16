/**
 * Algo Spec
 * @author Kai Matsuda
 */
package com.github.vangogh500
package math
package algebra

import org.scalatest.FlatSpec
import algos.AlgebraBehaviors

/**
 * Algo Spec
 */
class AlgoSpec extends FlatSpec with AlgebraBehaviors {
  "Algebra.gcd" should behave like gcd(Algo.gcd)
  "Algebra.gcdOpt" should behave like gcdOpt(Algo.gcdOpt)
}
