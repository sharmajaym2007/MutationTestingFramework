package visitors.RelationalVisitor;

import org.eclipse.jdt.core.dom.InfixExpression;

public class GreaterEqualToLessVisitor extends RORVisitor {
	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.GREATER_EQUALS)) {
			exp.setOperator(InfixExpression.Operator.LESS);
		}
	}
}
