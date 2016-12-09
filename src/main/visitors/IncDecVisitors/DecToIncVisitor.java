package main.visitors.IncDecVisitors;

import org.eclipse.jdt.core.dom.PostfixExpression;

public class DecToIncVisitor extends PORVisitor {

	public void replaceOperator(PostfixExpression exp) {
		if (exp.getOperator().equals(PostfixExpression.Operator.DECREMENT)) {
			exp.setOperator(PostfixExpression.Operator.INCREMENT);
		}
	}

}
