package visitors.ArithmeticVisitors;

import org.eclipse.jdt.core.dom.InfixExpression;

public class AddToModVisitor extends AORVisitor {

	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.PLUS)) {
			exp.setOperator(InfixExpression.Operator.REMAINDER);
		}
	}

}
