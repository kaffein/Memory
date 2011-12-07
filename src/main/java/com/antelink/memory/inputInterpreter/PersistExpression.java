package com.antelink.memory.inputInterpreter;

import com.antelink.memory.domain.Phrase;

public class PersistExpression extends AbstractExpression {
	
	private String phraseString;
	
	public PersistExpression(String phraseString) {
		this.phraseString = phraseString;
	}

	@Override
	public void interpret(InterpreterContext context) {
		Phrase phrase = new Phrase();
		phrase.setPhrase(phraseString);
		context.getPhraseManager().persist(phrase);
	}

}
