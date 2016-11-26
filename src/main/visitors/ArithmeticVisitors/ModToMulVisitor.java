package main.visitors.ArithmeticVisitors;

import org.eclipse.jdt.core.dom.InfixExpression;

public class ModToMulVisitor extends AORVisitor {

	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.REMAINDER)) {
			exp.setOperator(InfixExpression.Operator.TIMES);
		}
	}

}
