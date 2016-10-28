package visitors.RelationalVisitor;

import org.eclipse.jdt.core.dom.InfixExpression;

public class GreaterToNotEqualVisitor {
	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.GREATER)) {
			exp.setOperator(InfixExpression.Operator.NOT_EQUALS);
		}
	}
}
