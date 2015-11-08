package by.pavel.scala

object Calculator {

  def calculate(xs : List[Expression]) : List[Expression] = xs match {
    case Nil => List()
    case h :: t :: Nil => List(Addition(h, t), Subtraction(h, t))
    case h :: t => calculate(t)
      .map(e => (Addition(h, e), Subtraction(h, e)))
      .flatMap {case (a, s) => List(a, s)}
  }
}
