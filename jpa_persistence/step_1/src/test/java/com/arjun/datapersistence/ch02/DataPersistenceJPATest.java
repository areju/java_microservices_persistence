package com.arjun.datapersistence.ch02;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;;

public class DataPersistenceJPATest {
	
	@Test
	public void loadStoreMessage() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch02.ex01");
		
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			
			Message message = new Message();
			message.setText("Hello World!");
			
			em.persist(message);
			em.getTransaction().commit();
			
			em.getTransaction().begin();
			
			List<Message> messages = em.createQuery("select m from Message m").getResultList();
			
			messages.get(messages.size() - 1).setText("Hello World From JPA" );
			
			em.getTransaction().commit();
			
			assertAll(
					() -> assertEquals(1, messages.size()),
					() -> assertEquals("Hello World From JPA", messages.get(0).getText())
					);
			em.close();
		}finally {
			emf.close();
		}
		
	}

}
