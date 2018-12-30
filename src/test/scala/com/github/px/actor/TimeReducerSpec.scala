/**
 * Time reducer spec
 * @author Kai Matsuda
 */
package com.github.vangogh500
package actor

import entity.body.Body
import entity.body.{AttrQuantity, AttrQuality}
import math.Vec

import akka.actor.ActorSystem
import akka.testkit.{ ImplicitSender, TestActors, TestKit }
import org.scalatest.{ BeforeAndAfterAll, WordSpecLike, Matchers }

class TimeReducerSpec extends TestKit(ActorSystem("TimeReducerSpec")) with ImplicitSender
  with WordSpecLike with Matchers with BeforeAndAfterAll {
  override def afterAll: Unit = {
    TestKit.shutdownActorSystem(system)
  }
  "TimeReducer" must {
    "reduce a body" in {
      val actor = system.actorOf(TimeReducer.props[Body])
      actor ! TimeReducer.Req(1.0, Body(Map(
        AttrQuality.Scalar.Mass -> AttrQuantity(Vec(10))
      ), Map(
        AttrQuality.Vector.Displacement -> AttrQuantity(Vec(Vec(1.0,2.0,3.0), Vec(1.0,1.0,1.0), Vec(1.0,0.0,0.0)))
      )))
      expectMsg(TimeReducer.Res(Body(Map(
        AttrQuality.Scalar.Mass -> AttrQuantity(Vec(10))
      ), Map(
        AttrQuality.Vector.Displacement -> AttrQuantity(Vec(Vec(2.5,3.0,4.0), Vec(2.0,1.0,1.0), Vec(1.0,0.0,0.0)))
      ))))
    }
  }
}
