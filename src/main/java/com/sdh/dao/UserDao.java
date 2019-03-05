package com.sdh.dao;

import com.sdh.domain.User;

public interface UserDao {
	
	void insert(User user);
	
	User get(int id);
	
	void update(User user);
	
	void delete(int id);

}
