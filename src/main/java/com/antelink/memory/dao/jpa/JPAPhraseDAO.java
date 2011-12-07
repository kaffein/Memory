package com.antelink.memory.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.antelink.memory.dao.PhraseDAO;
import com.antelink.memory.domain.Phrase;

@Repository("phraseDAO")
public class JPAPhraseDAO implements PhraseDAO {
	private static final Log log = LogFactory.getLog(JPAPhraseDAO.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Phrase phrase) {
		log.info("Persisting phrase in DB...");
		try {
			entityManager.persist(phrase);
			log.info("Phrase persisted");
		} catch (Exception e) {
			e.printStackTrace();
			log.warn("Phrase not persisted : " + e.getMessage());
		}
	}

	public List<Phrase> findAll() {
		log.info("Fetching all phrases from DB...");
		try {
			List<Phrase> phrases = new ArrayList<Phrase>();
			phrases = entityManager.createQuery("FROM Phrase").getResultList();
			return phrases;
		} catch (Exception e) {
			e.printStackTrace();
			log.warn("Phrase not persisted : " + e.getMessage());
		}
		
		return null;
	}

	public void removeAll() {
		log.info("Resetting DB ...");
		try {
			entityManager.createQuery("DELETE FROM Phrase").executeUpdate();
			log.info("DB reset...");
		} catch (Exception e) {
			e.printStackTrace();
			log.warn("Phrase not persisted : " + e.getMessage());
		}
	}
	
}