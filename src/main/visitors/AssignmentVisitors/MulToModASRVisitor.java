package main.visitors.AssignmentVisitors;

import org.eclipse.jdt.core.dom.Assignment;

public class MulToModASRVisitor extends ASRVisitor {

	public void replaceOperator(Assignment exp) {
		if (exp.getOperator().equals(Assignment.Operator.TIMES_ASSIGN)) {
			exp.setOperator(Assignment.Operator.REMAINDER_ASSIGN);
		}
	}

}
