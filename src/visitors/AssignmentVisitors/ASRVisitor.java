package visitors.AssignmentVisitors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Assignment;

public abstract class ASRVisitor extends ASTVisitor {

	abstract void replaceOperator(Assignment exp);

	public boolean visit(Assignment exp) {
		replaceOperator(exp);
		return false;
	}

	public static List<ASTVisitor> getAssignmentVisitors() {
		List<ASTVisitor> visitors = new ArrayList<ASTVisitor>();
		// Addition
		visitors.add(new AddToDivASRVisitor());
		visitors.add(new AddToModASRVisitor());
		visitors.add(new AddToModASRVisitor());
		visitors.add(new AddToSubASRVisitor());

		// Division
		visitors.add(new DivToAddASRVisitor());
		visitors.add(new DivToModASRVisitor());
		visitors.add(new DivToMulASRVisitor());
		visitors.add(new DivToSubASRVisitor());

		// Modulo
		visitors.add(new ModToAddASRVisitor());
		visitors.add(new ModToDivASRVisitor());
		visitors.add(new ModToMulASRVisitor());
		visitors.add(new ModToSubASRVisitor());

		// Multiplication
		visitors.add(new MulToAddASRVisitor());
		visitors.add(new MulToDivASRVisitor());
		visitors.add(new MulToModASRVisitor());
		visitors.add(new MulToSubASRVisitor());

		// Subtraction
		visitors.add(new SubToAddASRVisitor());
		visitors.add(new SubToDivASRVisitor());
		visitors.add(new SubToModASRVisitor());
		visitors.add(new SubToMulASRVisitor());
		return visitors;
	}
}
