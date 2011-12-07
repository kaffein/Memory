package com.antelink.memory.inputInterpreter;

import org.springframework.beans.factory.annotation.Autowired;

import com.antelink.memory.service.PhraseManager;

public class InterpreterContext {
	
	@Autowired
	private PhraseManager phraseManager;
	
	public InterpreterContext() {
	}

	public PhraseManager getPhraseManager() {
		return phraseManager;
	}

	public void setPhraseManager(PhraseManager phraseManager) {
		this.phraseManager = phraseManager;
	}
}