package visitors.RelationalVisitor;

import org.eclipse.jdt.core.dom.InfixExpression;

public class LessToGreaterEqualVisitor extends RORVisitor {
	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.LESS)) {
			exp.setOperator(InfixExpression.Operator.GREATER_EQUALS);
		}
	}
}
