package visitors.ArithmeticVisitors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.InfixExpression;

public abstract class AORVisitor extends ASTVisitor{
	
	abstract void replaceOperator(InfixExpression exp);
	
	public boolean visit(InfixExpression exp){
		replaceOperator(exp);
		return false;
	}
	
	public static List<ASTVisitor> getArithmeticVisitors() {
		List<ASTVisitor> visitors = new ArrayList<ASTVisitor>();
		
		// Addition
		visitors.add(new AddToDivVisitor());
		visitors.add(new AddToModVisitor());
		visitors.add(new AddToModVisitor());
		visitors.add(new AddToSubVisitor());

		// Division
		visitors.add(new DivToAddVisitor());
		visitors.add(new DivToModVisitor());
		visitors.add(new DivToMulVisitor());
		visitors.add(new DivToSubVisitor());

		// Modulo
		visitors.add(new ModToAddVisitor());
		visitors.add(new ModToDivVisitor());
		visitors.add(new ModToMulVisitor());
		visitors.add(new ModToSubVisitor());

		// Multiplication
		visitors.add(new MulToAddVisitor());
		visitors.add(new MulToDivVisitor());
		visitors.add(new MulToModVisitor());
		visitors.add(new MulToSubVisitor());

		// Subtraction
		visitors.add(new SubToAddVisitor());
		visitors.add(new SubToDivVisitor());
		visitors.add(new SubToModVisitor());
		visitors.add(new SubToMulVisitor());
		return visitors;
	}

	
}	

