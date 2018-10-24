package dao;

import javax.persistence.EntityManager;

import entities.Person;
import util.ConnectionManager;

public class PersonDAO {
	private ConnectionManager cm = new ConnectionManager("MyPersistenceUnit");

	public void close() {
		cm.close();
	}

	public Person createPerson(Person entity) {
		EntityManager em = cm.getEMFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return entity;
	}
}
