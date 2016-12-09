package main.visitors.RelationalVisitor;

import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.InfixExpression;

public class NotEqualToLessEqualVisitor extends RORVisitor {
	public void replaceOperator(InfixExpression exp) {
		if (exp.getOperator().equals(InfixExpression.Operator.NOT_EQUALS)) {
			ITypeBinding lbinding = exp.getRightOperand().resolveTypeBinding();
			ITypeBinding rbinding = exp.getLeftOperand().resolveTypeBinding();
			if (lbinding != null && rbinding != null)
				exp.setOperator(InfixExpression.Operator.LESS_EQUALS);
		}
	}
}
