package by.pavel.scala


object Main extends App {
  val a = List(Number(2), Number(3))
  val res = Calculator.calculate(a).groupBy(e => e.value + " " + e.repr).keys
  println(res)
}
