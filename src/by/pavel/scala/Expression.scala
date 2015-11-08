package by.pavel.scala

sealed abstract class Expression(val value: Int, val repr: String) {}

case class Number(override val value: Int) extends Expression(value, value toString)

case class Addition(left: Expression, right: Expression) 
  extends Expression(left.value + right.value, left.repr + "+" + right.repr)

case class Subtraction(left: Expression, right: Expression)
  extends Expression(left.value - right.value, left.repr + "-" + right.repr)


