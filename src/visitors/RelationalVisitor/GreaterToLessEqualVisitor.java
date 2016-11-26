package visitors.RelationalVisitor;

import org.eclipse.jdt.core.dom.InfixExpression;

public class GreaterToLessEqualVisitor extends RORVisitor {
	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.GREATER)) {
			exp.setOperator(InfixExpression.Operator.LESS_EQUALS);
		}
	}
}
