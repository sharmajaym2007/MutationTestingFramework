package visitors.RelationalVisitor;

import org.eclipse.jdt.core.dom.InfixExpression;

public class LessEqualToNotEqualVisitor extends RORVisitor {
	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.LESS_EQUALS)) {
			exp.setOperator(InfixExpression.Operator.NOT_EQUALS);
		}
	}
}
