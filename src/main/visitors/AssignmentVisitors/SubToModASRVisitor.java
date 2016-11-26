package main.visitors.AssignmentVisitors;

import org.eclipse.jdt.core.dom.Assignment;

public class SubToModASRVisitor extends ASRVisitor {

	public void replaceOperator(Assignment exp) {
		if (exp.getOperator().equals(Assignment.Operator.MINUS_ASSIGN)) {
			exp.setOperator(Assignment.Operator.REMAINDER_ASSIGN);
		}
	}

}
