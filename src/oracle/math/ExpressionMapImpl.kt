package oracle.math

import oracle.math.business.Expression
import oracle.math.business.ExpressionMap

class ExpressionMapImpl(
        override val map: Map<String, Expression>
) : ExpressionMap {


    override fun getExpression(symbolName: String): Expression? = map.get(symbolName)

}
