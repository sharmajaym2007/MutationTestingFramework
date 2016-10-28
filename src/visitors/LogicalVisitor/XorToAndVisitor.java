package visitors.LogicalVisitor;

import org.eclipse.jdt.core.dom.InfixExpression;

public class XorToAndVisitor {
	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.XOR)) {
			exp.setOperator(InfixExpression.Operator.AND);
		}
	}
}
