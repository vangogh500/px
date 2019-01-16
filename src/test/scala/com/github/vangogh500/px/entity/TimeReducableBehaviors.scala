/**
 * TimeReducable Behaviors
 * @author Kai Matsuda
 */
package com.github.vangogh500
package entity

import org.scalatest.FlatSpec

/**
 * TimeReducable Behaviors
 */
trait TimeReducableBehaviors { this: FlatSpec =>
  def timeReducable[T <: TimeReducable[T]](in: T, dt1: Double, out1: T, dt2: Double, out2: T) {
    it should "time reduce correctly" in {
      assert(in.tReduce(dt1) == out1)
      assert(in.tReduce(dt2) == out2)
    }
  }
}
