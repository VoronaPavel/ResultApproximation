import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class Calculator {

  def calculate(nodes: List[List[Node]]) = {
    if (nodes.head.size == 1) return nodes

    val solutions: List[List[Node]] = List(List())
    for (n <- solutions) {
      for (reducer <- Problem1.Reducer.values) {
        val newNodes: List[Node] = List(n)
        val reducedNode: Node = reducer.reduce(newNodes.get(0), newNodes.get(1))
        newNodes.remove(1)
        newNodes.remove(0)
        newNodes.add(0, reducedNode)
        solutions.add(newNodes)
      }
    }
    calculate(solutions)
  }
}
