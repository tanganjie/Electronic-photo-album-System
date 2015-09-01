package com.dzxc.service;

import com.dzxc.entity.Dictionary.DQuestion;
import com.dzxc.entity.User.User;

public interface IUserService {
	public int login(User user);
	public void regist(User user);
	public User findCurrentUser(String name);
	public int count(String name);
	public boolean correctAnswer(User user);
	public void changePassword(User user);
	public User findById(int id);
}
