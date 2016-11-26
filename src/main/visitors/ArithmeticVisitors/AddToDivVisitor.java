package main.visitors.ArithmeticVisitors;

import org.eclipse.jdt.core.dom.InfixExpression;

public class AddToDivVisitor extends AORVisitor {

	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.PLUS)) {
			exp.setOperator(InfixExpression.Operator.DIVIDE);
		}
	}

}
