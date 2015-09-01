package com.dzxc.entity.User;

import com.dzxc.entity.Dictionary.DQuestion;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable {

	// Constructors

	private DQuestion dquestion;
	
	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userName, String passWord, String head, String question,
			String answer) {
		super(userName, passWord, head, question, answer);
	}

	/** full constructor */
	public User(String userName, String passWord, String head, String regDate,
			String question, String answer) {
		super(userName, passWord, head, regDate, question, answer);
	}

	public DQuestion getDquestion() {
		return dquestion;
	}

	public void setDquestion(DQuestion dquestion) {
		this.dquestion = dquestion;
	}

}
