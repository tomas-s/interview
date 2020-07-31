package artin

import java.lang.RuntimeException

fun main() {
    val root1 = NodeImpl(5, emptyList())

    val root = NodeImpl(
        5, listOf(
            NodeImpl(1, listOf(NodeImpl(5, emptyList()), NodeImpl(2, emptyList()))), NodeImpl(3, emptyList())
        )
    )

    println(getLevelSum(root1, 0))

}

interface Node {
    val value: Int
    val children: List<Node>
}


class NodeImpl(override val value: Int, override val children: List<Node>) : Node


/**
 * Please implement this method to
 * traverse the tree and return the sum of the values (Node.getValue()) of all nodes
 * at the level N in the tree.
 * Node root is assumed to be at the level 0. All its children are level 1, etc.
 */
fun getLevelSum(root: Node, n: Int): Int {
    if (n == 0) {
        return root.value
    }
    if (root.children.isEmpty() && n > 0) {
        throw RuntimeException("Root does not have $n levels")
    }

    return sumOfNodesAtLevel(root.children, 1, n)
}

fun sumOfNodesAtLevel(nodes: List<Node>, actualLevel: Int, maxLevel: Int): Int {
    val childs = mutableListOf<Node>()

    if (actualLevel >= maxLevel) {
        return nodes.map { it.value }.sum()
    }
    if (childs.isEmpty()) {
        throw RuntimeException("Root does not have $maxLevel levels")
    }
    nodes.forEach { childs.addAll(it.children) }

    return sumOfNodesAtLevel(childs, actualLevel + 1, maxLevel)
}
