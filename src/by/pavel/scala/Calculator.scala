package by.pavel.scala

object Calculator {

  def expressions(left : Expression, right : Expression) : List[Expression] =
    List(Addition(left, right), Subtraction(left, right))

  def calculate(exps : List[Expression]) : List[Expression] = exps match {
    case Nil           => List()
    case h :: Nil      => exps
    case h :: t        => calculate(t).flatMap(expressions(h, _ ))
  }
}
