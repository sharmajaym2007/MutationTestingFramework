package main.visitors.RelationalVisitor;

import org.eclipse.jdt.core.dom.InfixExpression;

public class EqualToNotEqualVisitor extends RORVisitor {
	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.EQUALS)) {
			exp.setOperator(InfixExpression.Operator.NOT_EQUALS);
		}
	}
}
