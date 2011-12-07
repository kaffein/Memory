package com.antelink.memory.inputInterpreter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.antelink.memory.domain.Phrase;

public class PhraseListExpression extends AbstractExpression {
	private static final Log log = LogFactory.getLog(PhraseListExpression.class);
	
	public PhraseListExpression() {
	}
	
	@Override
	public void interpret(InterpreterContext context) {
		List<Phrase> phrases = new ArrayList<Phrase>();
		phrases = context.getPhraseManager().findAll();
		for(Phrase phrase : phrases) {
			log.debug("Phrase => " + phrase.getPhrase());
		}
	}

}
