package by.pavel.scala

sealed abstract class Expression(val value: Int, val repr: String) {}

case class Number(num: Int) extends Expression(num, num toString)

case class Addition(left: Expression, right: Expression) 
  extends Expression(left.value + right.value, left.repr + "+" + right.repr)

case class Subtraction(left: Expression, right: Expression)
  extends Expression(left.value - right.value, left.repr + "-" + right.repr)


