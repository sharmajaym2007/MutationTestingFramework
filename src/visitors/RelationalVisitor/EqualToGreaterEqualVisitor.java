package visitors.RelationalVisitor;

import org.eclipse.jdt.core.dom.InfixExpression;

public class EqualToGreaterEqualVisitor {
	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.EQUALS)) {
			exp.setOperator(InfixExpression.Operator.GREATER_EQUALS);
		}
	}
}
