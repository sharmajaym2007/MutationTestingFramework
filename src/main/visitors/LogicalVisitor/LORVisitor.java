package main.visitors.LogicalVisitor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.InfixExpression;

public abstract class LORVisitor extends ASTVisitor{
	
	abstract void replaceOperator(InfixExpression exp);
	
	public boolean visit(InfixExpression exp){
		replaceOperator(exp);
		return false;
	}

	public static List<ASTVisitor> getLogicalVisitors() {
		List<ASTVisitor> visitors = new ArrayList<ASTVisitor>();
		
		// AND
		visitors.add(new AndToOrVisitor());
		visitors.add(new AndToXorVisitor());

		// OR
		visitors.add(new OrToAndVisitor());
		visitors.add(new OrToXorVisitor());

		// XOR
		visitors.add(new XorToAndVisitor());
		visitors.add(new XorToOrVisitor());
		return visitors;
	}
}	

