package visitors.RelationalVisitor;

import org.eclipse.jdt.core.dom.InfixExpression;

public class NotEqualToLessEqualVisitor {
	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.NOT_EQUALS)) {
			exp.setOperator(InfixExpression.Operator.LESS_EQUALS);
		}
	}
}