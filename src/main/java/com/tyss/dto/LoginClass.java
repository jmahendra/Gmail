package com.tyss.dto;

import java.io.IOException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.mj.dte.Account;

public class LoginClass {

	DaoClass d=new DaoClass();
	Scanner sc=new Scanner(System.in);
	EntityManagerFactory emf=null;

	EntityManager em=null;

	EntityTransaction et=null;
	String email=null;
	String password=null;

	public void login() throws IOException	{
		emf = Persistence.createEntityManagerFactory("Gmail");
		em = emf.createEntityManager();
		et = em.getTransaction();

		System.out.println("Enter email Id");
		 email=sc.next();
		System.out.println("Enter password");
		 password=sc.next();
		
		 
		Account a=em.find(Account.class,3);

		if((email.equals(a.getEmail()))&& (password.equals(a.getPassword())))
		{
			loginPage();
		}
	}
	void loginPage() throws IOException {
		do{
			System.out.println("1:Compose");
			System.out.println("2:Show Inbox");
			System.out.println("Enter your option");

			int option=sc.nextInt();

			switch(option){
			case 1:d.compose(email);
			break;
			case 2: d.showInbox(email);
			break;

			}
			System.out.println("do you want to continue");
			String res=sc.next();
			if(res.startsWith("n"))
			{
				break;
			}
		}while(true);
	}
}
