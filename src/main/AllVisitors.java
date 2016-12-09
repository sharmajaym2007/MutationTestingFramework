package main;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;

import main.visitors.ArithmeticVisitors.AORVisitor;
import main.visitors.AssignmentVisitors.ASRVisitor;
import main.visitors.IncDecVisitors.PORVisitor;
import main.visitors.LogicalVisitor.LORVisitor;
import main.visitors.RelationalVisitor.RORVisitor;
import main.visitors.ShiftVisitors.SORVisitor;

public class AllVisitors {

	public static List<ASTVisitor> getVisitors() {
		List<ASTVisitor> visitors = new ArrayList<ASTVisitor>();

		visitors.addAll(AORVisitor.getArithmeticVisitors());
		visitors.addAll(ASRVisitor.getAssignmentVisitors());
		visitors.addAll(LORVisitor.getLogicalVisitors());
		visitors.addAll(LORVisitor.getLogicalVisitors());
		visitors.addAll(RORVisitor.getRelationalVisitors());
		visitors.addAll(SORVisitor.getShiftVisitors());
		visitors.addAll(PORVisitor.getPostfixVisitors());
		
		return visitors;
	}
}
