package com.antelink.memory.service.impl;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.antelink.memory.dao.PhraseDAO;
import com.antelink.memory.domain.Phrase;

public class PhraseManagerImplTest {
	private PhraseDAO mockPhraseDAO = null;
	private PhraseManagerImpl phraseManager = null;

	@Before
	public void setUp() throws Exception {
		mockPhraseDAO = createMock(PhraseDAO.class);
		phraseManager = new PhraseManagerImpl();
		phraseManager.setPhraseDAO(mockPhraseDAO);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPersist() {
		mockPhraseDAO.persist((Phrase) EasyMock.anyObject());
		replay(mockPhraseDAO);
		
		Phrase phrase = new Phrase();
		phrase.setPhrase("My new Phrase");
		mockPhraseDAO.persist(phrase);
		
		verify(mockPhraseDAO);
		
	}

	@Test
	public void testFindAll() {
		List<Phrase> phrases = new ArrayList<Phrase>();
		Phrase phrase = new Phrase();
		phrase.setPhrase("This is my first sentence");
		phrases.add(phrase);
		phrase = new Phrase();
		phrase.setPhrase("This is another sentence");
		phrases.add(phrase);
		
		expect(mockPhraseDAO.findAll()).andStubReturn(phrases);
		
		replay(mockPhraseDAO);
		
		List<Phrase> results = new ArrayList<Phrase>();
		results = phraseManager.findAll();
		assertEquals(2, results.size());
		assertEquals("This is another sentence", results.get(1).getPhrase());
		
		verify(mockPhraseDAO);
	}

	@Test
	public void testRemoveAll() {
		mockPhraseDAO.removeAll();
		replay(mockPhraseDAO);
		
		mockPhraseDAO.removeAll();
		
		verify(mockPhraseDAO);
	}

}
