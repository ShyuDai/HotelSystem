package com.hs.service;

import java.util.List;

import com.hs.dao.UserDaoGH;
import com.hs.dao.impl.UserDaoImplGH;
import com.hs.entity.User;

public class UserServiceGH {
	UserDaoGH dao=new UserDaoImplGH();
   public boolean save(User user) {
	   return dao.save(user);
   }
	
	public boolean update(User user) {
		return dao.update(user);
	}
	
	public boolean delete(User user) {
		return dao.delete(user);
	}
	
	public User getUserById(int userid) {
		return dao.getUserById(userid);
	}
	
	public User getUserByEmpnumber(String empnumber) {
		return dao.getUserByEmpnumber(empnumber);
	}
	
	public int getUsersCountByPage(int attruCode,String value) {
		return dao.getUsersCountByPage(attruCode, value);
	}
	
	public List<User> getUsersByPage(int pageNo,int pageSize,int attruCode,String value){
		return dao.getUsersByPage(pageNo, pageSize, attruCode, value);
	}
	
}
