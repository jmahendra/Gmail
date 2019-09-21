package com.tyss.mj.gmail1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.dto.DaoClass;
import com.tyss.dto.LoginClass;
import com.tyss.mj.dte.Account;
import com.tyss.mj.dte.Inbox;

public class App {
	public static void main(String[] args) throws IOException {
		DaoClass d=new DaoClass();
		LoginClass lc=new LoginClass();

		Scanner sc=new Scanner(System.in);

		do
		{
			System.out.println("1:login");
			System.out.println("2:Register");
			System.out.println("Enter your option");

			int option=sc.nextInt();
			switch(option){
			case 1:lc.login();
			break;
			case 2:d.createAccount();
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