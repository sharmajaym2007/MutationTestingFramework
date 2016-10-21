package visitors.ArithmeticVisitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.InfixExpression;

public abstract class AORVisitor extends ASTVisitor{
	
	abstract void replaceOperator(InfixExpression exp);
	
	public boolean visit(InfixExpression exp){
		replaceOperator(exp);
		return false;
	}

	
}	

