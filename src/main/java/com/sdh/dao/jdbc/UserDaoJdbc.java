package com.sdh.dao.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sdh.dao.UserDao;
import com.sdh.domain.User;

@Repository
public class UserDaoJdbc implements UserDao {

	@Autowired
	private JdbcTemplate template;

	@Override
	public void insert(User user) {
		String query = "insert into user(id, password) values(?, ?)";
		template.update(query, user.getId(), user.getPassword());
	}

	@Override
	public User get(int userId) {
		String query = "select * from user where user_id = ?";
		return template.queryForObject(query, new Object[] { userId }, (result,
				rowNum) -> new User(result.getInt("user_id"), result.getString("id"), result.getString("password")));
	}

	@Override
	public void update(User user) {
		String query = "update user set id = ?, password = ? where user_id = ?";
		template.update(query, user.getId(), user.getPassword(), user.getUserId());
	}

	@Override
	public void delete(int userId) {
		String query = "delete from user where user_id = ?";
		template.update(query, userId);
	}

}
