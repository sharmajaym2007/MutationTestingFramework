package main.visitors.AssignmentVisitors;

import org.eclipse.jdt.core.dom.Assignment;

public class AddToSubASRVisitor extends ASRVisitor {

	public void replaceOperator(Assignment exp) {
		if (exp.getOperator().equals(Assignment.Operator.PLUS_ASSIGN)) {
			exp.setOperator(Assignment.Operator.MINUS_ASSIGN);
		}
	}

}
