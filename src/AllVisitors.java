import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;

import visitors.ArithmeticVisitors.AORVisitor;
import visitors.AssignmentVisitors.ASRVisitor;
import visitors.LogicalVisitor.LORVisitor;
import visitors.RelationalVisitor.RORVisitor;
import visitors.ShiftVisitors.SORVisitor;

public class AllVisitors {

	public static List<ASTVisitor> getVisitors() {
		List<ASTVisitor> visitors = new ArrayList<ASTVisitor>();

		visitors.addAll(AORVisitor.getArithmeticVisitors());
		visitors.addAll(ASRVisitor.getAssignmentVisitors());
		visitors.addAll(LORVisitor.getLogicalVisitors());
		visitors.addAll(LORVisitor.getLogicalVisitors());
		visitors.addAll(RORVisitor.getRelationalVisitors());
		visitors.addAll(SORVisitor.getShiftVisitors());

		return visitors;
	}
}
