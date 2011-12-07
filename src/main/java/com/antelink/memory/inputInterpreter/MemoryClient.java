package com.antelink.memory.inputInterpreter;

public class MemoryClient {
	private InterpreterContext context;

	public MemoryClient() {
	}

	public MemoryClient(InterpreterContext context) {
		this.context = context;
	}

	public InterpreterContext getContext() {
		return context;
	}

	public void setContext(InterpreterContext context) {
		this.context = context;
	}

	public void interpret(String[] args) {
		AbstractExpression expression = null;
		
		if(args.length == 0)
			expression = new PhraseListExpression();
		else if (args[0].equalsIgnoreCase("reset"))
			expression = new ResetExpression();
		else expression = new PersistExpression(args[0]);
		
		if(expression != null)
			expression.interpret(context);
	}

}