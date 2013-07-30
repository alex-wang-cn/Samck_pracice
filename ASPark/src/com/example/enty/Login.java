package com.example.enty;

import java.io.Serializable;

public class Login implements Serializable {
	private String personName;
	private String passWord;

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
