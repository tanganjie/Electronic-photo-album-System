package com.dzxc.entity.User;

/**
 * AbstractUser entity provides the base persistence definition of the User
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String passWord;
	private String head;
	private String regDate;
	private String question;
	private String answer;

	// Constructors

	/** default constructor */
	public AbstractUser() {
	}

	/** minimal constructor */
	public AbstractUser(String userName, String passWord, String head,
			String question, String answer) {
		this.userName = userName;
		this.passWord = passWord;
		this.head = head;
		this.question = question;
		this.answer = answer;
	}

	/** full constructor */
	public AbstractUser(String userName, String passWord, String head,
			String regDate, String question, String answer) {
		this.userName = userName;
		this.passWord = passWord;
		this.head = head;
		this.regDate = regDate;
		this.question = question;
		this.answer = answer;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getHead() {
		return this.head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getRegDate() {
		return this.regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}