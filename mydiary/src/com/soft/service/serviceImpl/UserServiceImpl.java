package com.soft.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soft.dao.UserDao;
import com.soft.domain.Author;
import com.soft.domain.User;
import com.soft.service.UserService;

@Transactional
@Service("userService")

public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	public boolean checklogin(User user){
		return userDao.checklogin(user);
	}
	public String registUser(User user){
		String err = "注册成功请登录吧";
		try {
			List<User> result = userDao.getUserByUserName(user);
			if(result == null || result.size() == 0){
				userDao.registUser(user);
			}else{
				err = "用户名已存在，请修改后重试";
			}
		} catch (Exception e) {
			e.printStackTrace();
			err = "系统错误请稍候重试";
		}
		return err;
	}
	
	public User getuser(String username){
		return userDao.getuser(username);
	}
	
	public List<String> getResource(Integer userid){
		List<String> list1 =new ArrayList<String>();
		List<Author> li=userDao.getResource(userid);
		if(li.size()!=0){
			for(int i=0;i<li.size();i++){
				System.out.println(li.get(i).getName());
				list1.add(li.get(i).getName());
				
			}
		}
		return list1;
	}
	@Override
	public boolean editUser(User user) {
		int cot = userDao.editUser(user);
		if(cot>=1){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public void updateLastLoginTime(Integer id) {
		User us = new User();
		us.setId(id);
		us.setLastLoginTime(new Date());
		userDao.updateLastLoginTime(us);
	}
	
	public void edtiuser(User user){
		userDao.edtiuser(user);
	}
	public User getById(Integer id){
		return userDao.getById(id);
	}
	
	@Pointcut("execution(public * com.soft.dao.impl.*.checklogin(..))")
    public void myMethod(){};
	
//	@Before("execution(public void com.soft.dao.impl.UserDaoImpl.checklogin(com.soft.domain.User))")
    @Before("myMethod()")
    public void before(User user){
		System.out.println("------------��ݿ������־-------");
	}
	@Override
	public void saveRealPath(String filePath) {
		userDao.saveRealPath(filePath);
		
	}
	@Override
	public String getRealPath() {
		return userDao.getRealPath();
		 
	}
	
}