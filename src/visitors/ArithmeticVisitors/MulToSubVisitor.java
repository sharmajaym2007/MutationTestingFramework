package visitors.ArithmeticVisitors;

import org.eclipse.jdt.core.dom.InfixExpression;

public class MulToSubVisitor extends AORVisitor {

	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.TIMES)) {
			exp.setOperator(InfixExpression.Operator.MINUS);
		}
	}

}
