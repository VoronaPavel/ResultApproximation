package by.pavel.scala


object Main extends App {
  val a = List(Number(2), Number(3), Number(4), Number(1))
  val b = Calculator.calculate(a).groupBy(e => e.value + " " + e.repr).keys
  println(b)
}
