package main.visitors.ArithmeticVisitors;

import org.eclipse.jdt.core.dom.InfixExpression;

public class DivToSubVisitor extends AORVisitor {

	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.DIVIDE)) {
			exp.setOperator(InfixExpression.Operator.MINUS);
		}
	}

}
