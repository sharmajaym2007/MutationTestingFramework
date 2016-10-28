package visitors.RelationalVisitor;

import org.eclipse.jdt.core.dom.InfixExpression;

public class LessEqualToLessVisitor {
	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.LESS_EQUALS)) {
			exp.setOperator(InfixExpression.Operator.LESS);
		}
	}
}
