package oracle


import oracle.math.ExpressionImpl
import oracle.math.ExpressionMapImpl
import oracle.math.types.Node

object Main {

    @JvmStatic
    fun main(args: Array<String>) {

        val map: Map<String, ExpressionImpl> = hashMapOf(
                "x" to ExpressionImpl(Node("+", mutableListOf(Node("1"), Node("y")))),
                "y" to ExpressionImpl(Node("abs", mutableListOf(Node("-",mutableListOf(Node("1"),Node("3"))))))
        )

        val expression = ExpressionImpl(
                Node("-",
                        mutableListOf(Node("3"), Node("*",
                                mutableListOf(Node("+",
                                        mutableListOf(Node("5"), Node("x"))),
                                        Node("+",
                                                mutableListOf(Node("x"),Node("y"),Node("1"))
                                        ))))))

        println(expression.calc(ExpressionMapImpl(map)))
    }
}
