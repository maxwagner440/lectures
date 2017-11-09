package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcUserDao implements UserDao {
	
	JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcUserDao(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	@Override
	public User getUserById(Long id) {
		String sqlGetUser = "SELECT * from user where id = ?";
		SqlRowSet set = jdbcTemplate.queryForRowSet(sqlGetUser, id);
		if(set.next()){
			return mapRowToUser(set);
		} else {
			return null;
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		String sqlGetUser = "SELECT * from user";
		SqlRowSet set = jdbcTemplate.queryForRowSet(sqlGetUser);
		while(set.next()){
			users.add(mapRowToUser(set));
		}
		
		return users;
	}

	@Override
	public boolean deleteUser(Long id) {
		String sqlDeleteUser = "DELETE FROM users WHERE id = ?";
		int rows = jdbcTemplate.update(sqlDeleteUser, id);
		return rows > 0;
	}

	@Override
	public void saveUser(User user) {
		String sqlUpdateUser = "UPDATE users SET name=?, username=?, email=? WHERE id = ?";
		jdbcTemplate.update(sqlUpdateUser, user.getName(), user.getUsername(), user.getEmail(), user.getId());

	}
	
	private User mapRowToUser(SqlRowSet row) {
		User user = new User();
		user.setName(row.getString("name"));
		user.setUsername(row.getString("username"));
		user.setEmail(row.getString("email"));
		return user;
	}

}
