package com.antelink.memory.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antelink.memory.dao.PhraseDAO;
import com.antelink.memory.domain.Phrase;
import com.antelink.memory.service.PhraseManager;

@Service("phraseManager")
@Transactional
public class PhraseManagerImpl implements PhraseManager {

	@Autowired
	private PhraseDAO phraseDAO;

	private final Log log = LogFactory.getLog(PhraseManagerImpl.class);

	public PhraseDAO getPhraseDAO() {
		return phraseDAO;
	}

	public void setPhraseDAO(PhraseDAO phraseDAO) {
		this.phraseDAO = phraseDAO;
	}

	public void persist(Phrase phrase) {
		phraseDAO.persist(phrase);
	}

	@Transactional(readOnly = true)
	public List<Phrase> findAll() {
		return phraseDAO.findAll();
	}

	public void removeAll() {
		phraseDAO.removeAll();
	}

}
