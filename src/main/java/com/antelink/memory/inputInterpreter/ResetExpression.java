package com.antelink.memory.inputInterpreter;

public class ResetExpression extends AbstractExpression {
	
	public ResetExpression() {
	}

	@Override
	public void interpret(InterpreterContext context) {
		context.getPhraseManager().removeAll();
	}

}
