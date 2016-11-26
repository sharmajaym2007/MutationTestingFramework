package main.visitors.ShiftVisitors;

import org.eclipse.jdt.core.dom.InfixExpression;

public class RightToLeftVisitor extends SORVisitor {

	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.RIGHT_SHIFT_SIGNED)) {
			exp.setOperator(InfixExpression.Operator.LEFT_SHIFT);
		}
	}

}
