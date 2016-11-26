package main.visitors.RelationalVisitor;

import org.eclipse.jdt.core.dom.InfixExpression;

public class LessToNotEqualVisitor extends RORVisitor {
	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.LESS)) {
			exp.setOperator(InfixExpression.Operator.NOT_EQUALS);
		}
	}
}
