package visitors.LogicalVisitor;

import org.eclipse.jdt.core.dom.InfixExpression;

public class AndToORVisitor extends LORVisitor {

	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.AND)) {
			exp.setOperator(InfixExpression.Operator.OR);
		}
	}

}