package com.antelink.memory.dao;

import java.util.List;

import com.antelink.memory.domain.Phrase;

public interface PhraseDAO {

	public void persist(Phrase phrase);

	public List<Phrase> findAll();

	public void removeAll();

}
