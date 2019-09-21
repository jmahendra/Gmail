package com.tyss.mj.gmail1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.mj.dte.Account;
import com.tyss.mj.dte.Inbox;

public class Simple 
{
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Gmail");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		Inbox i = new Inbox();

		i.setMessage("this is gmail");

		List<Inbox> list = new ArrayList<Inbox>();
		list.add(i);

		Account a = new Account();

		
		a.setUser_Name("Dinga");
		a.setPassword("Dinga@123");
		a.setInbox(list);

		try {
			et.begin();

			em.persist(a);

			et.commit();
			System.out.println("data stored");
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}

	}
}
