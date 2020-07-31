package oracle.math

import oracle.math.business.Expression
import oracle.math.exception.CalculateException
import oracle.math.types.Node
import kotlin.math.absoluteValue

class ExpressionImpl(override val root: Node

) : Expression {
    val referencedSymbols = mutableSetOf<String>()


    override fun calc(map: ExpressionMapImpl): Double {
        val resolveReferences = resolveReferences(root, map)
        return calculateNode(resolveReferences, map).value.toDouble()

    }

    private fun calculateNode(node: Node, map: ExpressionMapImpl): Node {
        val iterator = node.leafs.listIterator()
        while (iterator.hasNext()) {
            val leaf = iterator.next()
            if (leaf.isReferencedSymbol()) {
                iterator.set(map.getExpression(leaf.value)!!.root)
            }
            if (leaf.isOperator()) {
                iterator.set(calculateNode(leaf, map))
            }
        }
        return resolveRoot(node)

    }

    override fun resolveReferences(node: Node, map: ExpressionMapImpl): Node {
        val iterator = node.leafs.listIterator()
        while (iterator.hasNext()) {
            val leaf = iterator.next()
            if (leaf.isOperator()) {
                resolveReferences(leaf, map)
            }
            if (leaf.isReferencedSymbol()) {
                val expresionNode = map.getExpression(leaf.value)!!.run {
                    this.resolveReferences(this.root, map)
                }
                iterator.set(expresionNode)
            }
        }
        return node
    }

    override fun getReferencedSymbols(): List<String> {
        addIfLeafisReferencedSymbol(root)
        return referencedSymbols.toList()
    }

    fun addIfLeafisReferencedSymbol(node: Node) {
        if (node.isReferencedSymbol()) referencedSymbols.add(node.value)
        for (leaf: Node in node.leafs) {
            if (leaf.leafs.size > 0) addIfLeafisReferencedSymbol(leaf)
            else if (leaf.isReferencedSymbol()) referencedSymbols.add(leaf.value)
        }
    }


    private fun resolveRoot(root: Node): Node {

        val result = when (root.value) {
            "+" -> return Node(suma(root.leafs).toString())
            "-" -> return Node(minus(root.leafs).toString())
            "/" -> return Node(division(root.leafs).toString())
            "*" -> return Node(multiplication(root.leafs).toString())
            "abs" -> return Node(abs(root.leafs).toString())
            else -> throw CalculateException("Operator not recoginezed")
        }
    }


    private fun abs(leafs: List<Node>): Double {
        if (leafs.size != 1) throw CalculateException("ABS need just 1 node")
        return leafs.get(0).value.toDouble().absoluteValue
    }

    private fun division(leafs: List<Node>): Double {
        if (leafs.size != 2) throw CalculateException("ABS need just 1 node")
        return leafs.get(0).value.toDouble() / leafs.get(1).value.toDouble()
    }

    private fun multiplication(leafs: List<Node>): Double {
        if (leafs.size < 2) throw CalculateException("For multiplication need at least two child node")
        var result: Double = 1.0
        for (tempVal in leafs.map { it.value.toDouble() }) {
            result *= tempVal
        }
        return result
    }

    private fun minus(leafs: List<Node>): Double {
        if (leafs.size != 2) throw CalculateException("ABS need just 1 node")
        return leafs.get(0).value.toDouble() - leafs.get(1).value.toDouble()
    }

    private fun suma(leafs: List<Node>): Double {
        val leafsValues = leafs.map { it.value.toDouble() }
        if (leafs.size < 1) throw CalculateException("For suma need at least one child node")
        return leafsValues.sum()
    }


}