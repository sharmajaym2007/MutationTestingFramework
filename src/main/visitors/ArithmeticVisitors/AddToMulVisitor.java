package main.visitors.ArithmeticVisitors;

import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.InfixExpression;

public class AddToMulVisitor extends AORVisitor {

	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.PLUS)) {
			ITypeBinding lbinding = exp.getRightOperand().resolveTypeBinding();
			ITypeBinding rbinding = exp.getLeftOperand().resolveTypeBinding();
			if (lbinding != null && rbinding != null && !lbinding.getName().equals("String")
					&& !rbinding.getName().equals("String"))
				exp.setOperator(InfixExpression.Operator.TIMES);
		}
	}

}
