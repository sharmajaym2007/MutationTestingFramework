package main.visitors.ArithmeticVisitors;

import org.eclipse.jdt.core.dom.InfixExpression;

public class AddToMulVisitor extends AORVisitor {

	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.PLUS)) {
			exp.setOperator(InfixExpression.Operator.TIMES);
		}
	}

}
