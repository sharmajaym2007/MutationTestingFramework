package main.visitors.RelationalVisitor;

import org.eclipse.jdt.core.dom.InfixExpression;

public class EqualToLessEqualVisitor extends RORVisitor {
	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.EQUALS)) {
			exp.setOperator(InfixExpression.Operator.LESS_EQUALS);
		}
	}
}
