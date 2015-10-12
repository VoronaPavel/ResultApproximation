sealed class Reducer(function: (Int, Int) => Int, representation: String) {
  def reduce(left: Node, right: Node) = Node(function(left.value, right.value), representation)
}

case object Plus extends Reducer((left: Int, right: Int) => left + right, " + ")

case object Minus extends Reducer((left: Int, right: Int) => left - right, " - ")
