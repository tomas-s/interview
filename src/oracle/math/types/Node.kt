package oracle.math.types

data class Node(
        val value: String,
        val leafs: MutableList<Node> = mutableListOf()
) {
    fun isOperator(): Boolean {
        when (value) {
            "+", "-", "*", "/", "abs" -> return true
            else -> return false
        }
    }

    fun isReferencedSymbol(): Boolean{
        val double = value.toDoubleOrNull()
        if (double!=null) return false
        else return !isOperator()
    }


}