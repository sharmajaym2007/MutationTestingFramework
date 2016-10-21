package visitors.AssignmentVisitors;

import org.eclipse.jdt.core.dom.Assignment;

public class AddToMulASRVisitor extends ASRVisitor {

	public void replaceOperator(Assignment exp) {
		if (exp.getOperator().equals(Assignment.Operator.PLUS_ASSIGN)) {
			exp.setOperator(Assignment.Operator.TIMES_ASSIGN);
		}
	}

}
