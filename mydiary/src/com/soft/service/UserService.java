package com.soft.service;

import java.util.List;

import com.soft.domain.User;

public interface UserService {
	public boolean checklogin(User user);
	public String registUser(User user);
	public User getuser(String username);
	public List<String> getResource(Integer userid);
	public void edtiuser(User user);
	public User getById(Integer id);
	public boolean editUser(User user);
	public void updateLastLoginTime(Integer id);
	public void saveRealPath(String filePath);
	public String getRealPath();
}
