package com.techelevator.model;

import java.util.List;

public interface UserDao {
	public User getUserById(Long id);
	public List<User> getAllUsers();
	public boolean deleteUser(Long id);
	public void saveUser(User user);
}
