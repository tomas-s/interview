package oracle.math.business

import oracle.math.ExpressionMapImpl
import oracle.math.types.Node

interface Expression {
    val root: Node


    fun calc(map: ExpressionMapImpl): Number

    fun getReferencedSymbols(): List<String>

    fun resolveReferences(node: Node, map: ExpressionMapImpl): Node

}