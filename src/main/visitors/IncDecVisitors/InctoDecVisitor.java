package main.visitors.IncDecVisitors;

import org.eclipse.jdt.core.dom.PostfixExpression;

public class InctoDecVisitor extends PORVisitor {

	public void replaceOperator(PostfixExpression exp) {
		if (exp.getOperator().equals(PostfixExpression.Operator.INCREMENT)) {
			exp.setOperator(PostfixExpression.Operator.DECREMENT);
		}
	}

}
