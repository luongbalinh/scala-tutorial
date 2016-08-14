package scalacheck

import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Gen._
import org.scalacheck._

object CaseClassGenerator {
  val genLeaf = const(Leaf)

  val genNode = for {
    v <- arbitrary[Int]
    left <- genTree
    right <- genTree
  } yield Node(left, right, v)

  def genTree: Gen[Tree] = oneOf(genLeaf, genNode)

  // generate a sample tree
  genTree.sample
}

sealed abstract class Tree

case class Node(left: Tree, right: Tree, v: Int) extends Tree

case object Leaf extends Tree
