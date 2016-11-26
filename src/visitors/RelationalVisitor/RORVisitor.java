package visitors.RelationalVisitor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.InfixExpression;

public abstract class RORVisitor extends ASTVisitor{
	
	abstract void replaceOperator(InfixExpression exp);
	
	public boolean visit(InfixExpression exp){
		replaceOperator(exp);
		return false;
	}

	public static List<ASTVisitor> getRelationalVisitors() {
		List<ASTVisitor> visitors = new ArrayList<ASTVisitor>();
		
		// EQUAL`
		visitors.add(new EqualToGreaterEqualVisitor());
		visitors.add(new EqualToGreaterVisitor());
		visitors.add(new EqualToLessEqualVisitor());
		visitors.add(new EqualToLessVisitor());
		visitors.add(new EqualToNotEqualVisitor());

		// GREATER_EQUAL
		visitors.add(new GreaterEqualToEqualVisitor());
		visitors.add(new GreaterEqualToGreaterVisitor());
		visitors.add(new GreaterEqualToLessEqualVisitor());
		visitors.add(new GreaterEqualToLessVisitor());
		visitors.add(new GreaterEqualToNotEqualVisitor());

		// GREATER
		visitors.add(new GreaterToEqualVisitor());
		visitors.add(new GreaterToGreaterEqualVisitor());
		visitors.add(new GreaterToLessEqualVisitor());
		visitors.add(new GreaterToLessVisitor());
		visitors.add(new GreaterToNotEqualVisitor());
		
		// LESS_EQUAL
		visitors.add(new LessEqualToEqualVisitor());
		visitors.add(new LessEqualToGreaterEqualVisitor());
		visitors.add(new LessEqualToGreaterVisitor());
		visitors.add(new LessEqualToLessVisitor());
		visitors.add(new LessEqualToNotEqualVisitor());
		
		// LESS
		visitors.add(new LessToEqualVisitor());
		visitors.add(new LessToGreaterEqualVisitor());
		visitors.add(new LessToGreaterVisitor());
		visitors.add(new LessToLessEqualVisitor());
		visitors.add(new LessToNotEqualVisitor());
		
		//NOT EQUAL
		visitors.add(new NotEqualToEqualVisitor());
		visitors.add(new NotEqualToGreaterEqualVisitor());
		visitors.add(new NotEqualToLessEqualVisitor());
		visitors.add(new NotEqualToGreaterVisitor());
		visitors.add(new NotEqualToLessVisitor());
		return visitors;
	}
}	