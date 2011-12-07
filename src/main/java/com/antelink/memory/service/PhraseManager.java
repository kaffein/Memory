package com.antelink.memory.service;

import java.util.List;

import com.antelink.memory.domain.Phrase;


public interface PhraseManager {
	
	public void persist(Phrase phrase);
	
	public List<Phrase> findAll();
	
	public void removeAll();
	
}
