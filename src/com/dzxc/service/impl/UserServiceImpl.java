package com.dzxc.service.impl;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dzxc.base.service.BaseService;
import com.dzxc.entity.Dictionary.DQuestion;
import com.dzxc.entity.User.User;
import com.dzxc.service.IUserService;
import com.dzxc.util.MD5;

public class UserServiceImpl extends BaseService implements IUserService {
	@Override
	public int login(User user) {
		// TODO Auto-generated method stub
		System.out.print(user.getUserName()+"&&"+user.getPassWord());
		MD5 md5 = new MD5();  
		List<User> list=this.getUserDAO().findByUserName(user.getUserName());
		if(list.size()==1&&!list.get(0).getPassWord().equals(md5.getMD5ofStr(user.getPassWord())))
			return 0;//密码错误
		else if(list.size()==1&&list.get(0).getPassWord().equals(md5.getMD5ofStr(user.getPassWord()))){
			if(user.getUserName().equals("admin"))
				return 2;//管理员
			else
				return 1;//登陆成功
		}
		else
			return -1;//未知错误
	}

	@Override
	public void regist(User user) {
		// TODO Auto-generated method stub
		Date date = new Date();
		MD5 md5 = new MD5();  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		user.setRegDate(sdf.format(date));
		user.setPassWord(md5.getMD5ofStr(user.getPassWord()));
		this.getUserDAO().save(user);
	}

	@Override
	public User findCurrentUser(String name) {
		// TODO Auto-generated method stub
		return (User) this.getUserDAO().findByUserName(name).get(0);
	}

	@Override
	public int count(String name) {
		// TODO Auto-generated method stub
		return this.getUserDAO().findByUserName(name).size();
	}

	@Override
	public boolean correctAnswer(User user) {
		// TODO Auto-generated method stub
		User iuser=this.findCurrentUser(user.getUserName());
		if(iuser.getAnswer().equals(user.getAnswer()))
			return true;
		else
			return false;
	}

	@Override
	public void changePassword(User user) {
		// TODO Auto-generated method stub
		MD5 md5 = new MD5();
		User iuser=(User) this.getUserDAO().findByUserName(user.getUserName()).get(0);
		iuser.setPassWord(md5.getMD5ofStr(user.getPassWord()));
		this.getUserDAO().merge(iuser);
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return this.getUserDAO().findById(id);
	}
}