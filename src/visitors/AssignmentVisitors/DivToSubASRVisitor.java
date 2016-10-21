package visitors.AssignmentVisitors;

import org.eclipse.jdt.core.dom.Assignment;

public class DivToSubASRVisitor extends ASRVisitor {

	public void replaceOperator(Assignment exp) {
		if (exp.getOperator().equals(Assignment.Operator.DIVIDE_ASSIGN)) {
			exp.setOperator(Assignment.Operator.MINUS_ASSIGN);
		}
	}

}
