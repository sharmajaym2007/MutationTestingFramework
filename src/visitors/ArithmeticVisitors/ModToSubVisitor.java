package visitors.ArithmeticVisitors;

import org.eclipse.jdt.core.dom.InfixExpression;

public class ModToSubVisitor extends AORVisitor {

	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.REMAINDER)) {
			exp.setOperator(InfixExpression.Operator.MINUS);
		}
	}

}
