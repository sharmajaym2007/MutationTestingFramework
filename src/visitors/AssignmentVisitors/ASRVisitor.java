package visitors.AssignmentVisitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Assignment;

public abstract class ASRVisitor extends ASTVisitor{
	
	abstract void replaceOperator(Assignment exp);
	
	public boolean visit(Assignment exp){
		replaceOperator(exp);
		return false;
	}

	
}	

