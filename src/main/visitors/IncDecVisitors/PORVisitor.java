package main.visitors.IncDecVisitors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.PostfixExpression;

public abstract class PORVisitor extends ASTVisitor{
	
	abstract void replaceOperator(PostfixExpression exp);
	
	public boolean visit(PostfixExpression exp){
		replaceOperator(exp);
		return false;
	}
	
	public static List<ASTVisitor> getPostfixVisitors() {
		List<ASTVisitor> visitors = new ArrayList<ASTVisitor>();
		
		// LEFT_RIGHT`
		visitors.add(new DecToIncVisitor());
		
		//RIGHT_LEFT
		visitors.add(new InctoDecVisitor());
		return visitors;
	}
	
}	

