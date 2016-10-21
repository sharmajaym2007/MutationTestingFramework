package visitors.ArithmeticVisitors;

import org.eclipse.jdt.core.dom.InfixExpression;

public class SubToMulVisitor extends AORVisitor {

	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.MINUS)) {
			exp.setOperator(InfixExpression.Operator.TIMES);
		}
	}

}
