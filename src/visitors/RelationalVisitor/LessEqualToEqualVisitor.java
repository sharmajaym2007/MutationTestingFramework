package visitors.RelationalVisitor;

import org.eclipse.jdt.core.dom.InfixExpression;

public class LessEqualToEqualVisitor {
	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.LESS_EQUALS)) {
			exp.setOperator(InfixExpression.Operator.EQUALS);
		}
	}
}