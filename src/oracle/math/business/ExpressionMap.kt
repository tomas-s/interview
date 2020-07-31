package oracle.math.business

import oracle.math.ExpressionImpl

interface ExpressionMap {
    val map: Map<String, Expression>


    fun getExpression(symbolName: String): Expression?
}