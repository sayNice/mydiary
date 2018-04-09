package com.soft.dao.daoImpl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.soft.dao.PhotoDao;
import com.soft.domain.Photo;
import com.soft.domain.Search;

@Repository(value="photoDao")
public class PhotoDaoImpl extends SqlMapClientDaoSupport implements PhotoDao{

	@Override
	public int insert(Photo ph) {
		this.getSqlMapClientTemplate().insert("photo.insert",ph);
		return 1;
	}

	@Override
	public List<Photo> getPhotos(Search s) {
		@SuppressWarnings("unchecked")
		List<Photo> result = this.getSqlMapClientTemplate().queryForList("photo.getPhotos",s);
		return result;
	}

	@Override
	public Photo getPhotoInfo(Integer id) {
		return (Photo) this.getSqlMapClientTemplate().queryForObject("photo.getPhotoInfo",id);
	}

	@Override
	public void updatePhotoInfo(Photo ph) {
		this.getSqlMapClientTemplate().update("photo.updatePhotoInfo",ph);
	}

	@Override
	public Integer getPhotoCount(Integer userId) {
		Integer cot = (Integer) this.getSqlMapClientTemplate().queryForObject("photo.getPhotoCount",userId);
		return cot;
	}

}
