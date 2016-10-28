package visitors.LogicalVisitor;

import org.eclipse.jdt.core.dom.InfixExpression;

public class OrToAndVisitor {
	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.OR)) {
			exp.setOperator(InfixExpression.Operator.AND);
		}
	}

}
