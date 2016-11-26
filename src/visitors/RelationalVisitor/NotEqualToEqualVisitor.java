package visitors.RelationalVisitor;

import org.eclipse.jdt.core.dom.InfixExpression;

public class NotEqualToEqualVisitor extends RORVisitor {
	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.NOT_EQUALS)) {
			exp.setOperator(InfixExpression.Operator.EQUALS);
		}
	}
}
