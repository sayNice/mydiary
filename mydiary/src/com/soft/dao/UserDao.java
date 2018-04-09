package com.soft.dao;

import java.util.List;

import com.soft.domain.Author;
import com.soft.domain.User;

public interface UserDao {
	public boolean checklogin(User user);
	public boolean registUser(User user);
	public User getuser(String user);
	public List<Author> getResource(Integer userid);
	public void edtiuser(User user);
	public User getById(Integer id);
	public int editUser(User user);
	public void updateLastLoginTime(User us);
	public void saveRealPath(String filePath);
	public String getRealPath();
	public List<User> getUserByUserName(User user);
}
