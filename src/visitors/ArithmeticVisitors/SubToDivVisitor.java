package visitors.ArithmeticVisitors;

import org.eclipse.jdt.core.dom.InfixExpression;

public class SubToDivVisitor extends AORVisitor {

	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.MINUS)) {
			exp.setOperator(InfixExpression.Operator.DIVIDE);
		}
	}

}
