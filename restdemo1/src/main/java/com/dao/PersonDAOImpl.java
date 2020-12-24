package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Person;
import org.hibernate.Session;

import org.hibernate.SessionFactory;

@Repository
public class PersonDAOImpl implements PersonDAO {
	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	@Transactional
	public void addPerson(Person p) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(p);

	}

	@Override
	@Transactional
	public void updatePerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Person> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> personsList = session.createQuery("from Person").list();
		/*
		 * for(Person p : personsList){ logger.info("Person List::"+p); }
		 */
		return personsList;
	}

	@Override
	@Transactional
	public Person getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));

		return p;
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}

	}

}