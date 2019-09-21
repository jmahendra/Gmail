package com.tyss.dto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.mj.dte.Account;
import com.tyss.mj.dte.Inbox;

public class DaoClass {

	EntityManagerFactory emf=null;
	EntityManager em=null;
	EntityTransaction et=null;
	BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	Scanner sc=new Scanner(System.in);
	public	void compose(String email) throws IOException{

		emf = Persistence.createEntityManagerFactory("Gmail");
		em = emf.createEntityManager();
		et = em.getTransaction();

		
		System.out.println("Enter message");
		String message=reader.readLine();

		Inbox i=new Inbox();
		i.setMessage(message);

		try {
			et.begin();

			em.persist(i);

			et.commit();
			System.out.println("message composed");
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	public void showInbox(String email){

		emf = Persistence.createEntityManagerFactory("Gmail");
		em = emf.createEntityManager();
		et = em.getTransaction();
		
		
		Inbox a=em.find(Inbox.class, 11);
		
		System.out.println(a.getMessage());
		
	}
	public void createAccount(){
		emf = Persistence.createEntityManagerFactory("Gmail");
		em = emf.createEntityManager();
		et = em.getTransaction();

		System.out.println("Enter user Name");
		String uName=sc.next();
		System.out.println("Enter email");
		String email=sc.next();
		System.out.println("Enter password");
		String password=sc.next();



		Inbox i=new Inbox();
		System.out.println("Enter message");
		String msg=sc.next();
		i.setMessage(msg);

		List<Inbox> list=new ArrayList<Inbox>();
		list.add(i)	;
		Account a=new Account();
		a.setUser_Name(uName);
		a.setEmail(email);
		a.setPassword(password);
		a.setInbox(list);
		et.begin();

		em.persist(a);

		et.commit();
		System.out.println("account Created..");
	}
}
