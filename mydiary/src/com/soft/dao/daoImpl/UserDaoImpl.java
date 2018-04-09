package com.soft.dao.daoImpl;



import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.soft.dao.UserDao;
import com.soft.domain.Author;
import com.soft.domain.User;

@Repository(value="userDao")
public class UserDaoImpl extends SqlMapClientDaoSupport implements UserDao{

	public boolean checklogin(User user){
		User user1=(User) this.getSqlMapClientTemplate().queryForObject("user.checkuser",user);
		if(user1!=null){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean registUser(User user){
		this.getSqlMapClientTemplate().insert("user.insertuser",user);
		return true;
	}
	
	@Override
	public int editUser(User user) {
		int cot = this.getSqlMapClientTemplate().update("user.updateUser",user);
		return cot;
	}
	
	public User getuser(String user){
		User use=(User) this.getSqlMapClientTemplate().queryForObject("user.getuser",user);
		return use;
	}
	public List<Author> getResource(Integer userid){
		 List<Author> li=this.getSqlMapClientTemplate().queryForList("user.getResource",userid);
		 return li;
	}
	public void edtiuser(User user){
		this.getSqlMapClientTemplate().update("user.edituser",user);
	}
	public User getById(Integer id){
		return (User) this.getSqlMapClientTemplate().queryForObject("user.getbyid",id);
	}

	@Override
	public void updateLastLoginTime(User us) {
		this.getSqlMapClientTemplate().update("user.updateLastLoginTime",us);
	}

	@Override
	public void saveRealPath(String filePath) {
		this.getSqlMapClientTemplate().update("user.updatePath",filePath);
		
	}

	@Override
	public String getRealPath() {
		String realPath = (String) this.getSqlMapClientTemplate().queryForObject("user.getRealPath");
		return realPath;
	}

	@Override
	public List<User> getUserByUserName(User user) {
		List<User> use=this.getSqlMapClientTemplate().queryForList("user.getUserByUserName",user);
		return use;
	}

	
}
