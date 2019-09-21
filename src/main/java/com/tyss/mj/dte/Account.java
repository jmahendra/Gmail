package com.tyss.mj.dte;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table	
public class Account {
	@Id
	@GeneratedValue
	private int user_Id;
	@Column
	private String user_Name;
	@Column
	private String password;
	
	private String email;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="user_Id",nullable=false)
	private List<Inbox> inbox;
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Inbox> getInbox() {
		return inbox;
	}
	public void setInbox(List<Inbox> inbox) {
		this.inbox = inbox;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Account [user_Id=" + user_Id + ", user_Name=" + user_Name + ", password=" + password + ", email="
				+ email + ", inbox=" + inbox + "]";
	}
	
	
}
