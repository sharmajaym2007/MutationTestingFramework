package visitors.ShiftVisitors;

import org.eclipse.jdt.core.dom.InfixExpression;

public class LeftToRightVisitor extends SORVisitor {

	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.LEFT_SHIFT)) {
			exp.setOperator(InfixExpression.Operator.RIGHT_SHIFT_SIGNED);
		}
	}

}
