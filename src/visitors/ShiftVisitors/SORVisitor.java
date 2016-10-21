package visitors.ShiftVisitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.InfixExpression;

public abstract class SORVisitor extends ASTVisitor{
	
	abstract void replaceOperator(InfixExpression exp);
	
	public boolean visit(InfixExpression exp){
		replaceOperator(exp);
		return false;
	}

	
}	

