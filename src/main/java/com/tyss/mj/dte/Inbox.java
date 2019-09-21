package com.tyss.mj.dte;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Inbox {
	@Id
	@GeneratedValue
	private int message_Id;
	@Column
	private String message;
	public int getMessage_Id() {
		return message_Id;
	}
	public void setMessage_Id(int message_Id) {
		this.message_Id = message_Id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
