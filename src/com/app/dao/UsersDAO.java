package com.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.entity.Users;

public class UsersDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	@Override
	public Users create(Users users) {
		return super.create(users);
	}

	@Override
	public Users update(Users users) {
		return super.update(users);
	}

	@Override
	public Users find(Object id) {
		return super.find(Users.class,id);
	}

	@Override
	public void delete(Object id) {
		delete(Users.class,id);
	}

	@Override
	public List<Users> listAll() {
		return super.findWithNameQuery("Users.findAll");
	}

	@Override
	public long count() {
		return super.count("Users.countAll");
	}

	public Users findByEmail(String email) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);
		List<Users> lst = super.findWithNameQuery("Users.findByEmail", parameters);
		if(lst != null && lst.size()>0) {
			return lst.get(0);
		}
		return null;
		
	}
	
	
	public boolean checkLogin(String email,String password) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);
		parameters.put("password", password);
		List<Users> lst = super.findWithNameQuery("Users.checkLogin", parameters);
		if(lst.size() == 1 ) {
			return true;
		}
		return false;
	}
	
}
