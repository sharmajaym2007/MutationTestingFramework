package visitors.ShiftVisitors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.InfixExpression;

public abstract class SORVisitor extends ASTVisitor{
	
	abstract void replaceOperator(InfixExpression exp);
	
	public boolean visit(InfixExpression exp){
		replaceOperator(exp);
		return false;
	}
	
	public static List<ASTVisitor> getShiftVisitors() {
		List<ASTVisitor> visitors = new ArrayList<ASTVisitor>();
		
		// LEFT_RIGHT`
		visitors.add(new LeftToRightVisitor());
		
		//RIGHT_LEFT
		visitors.add(new RightToLeftVisitor());
		return visitors;
	}
	
}	

