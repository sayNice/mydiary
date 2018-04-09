package com.soft.service.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soft.dao.PhotoDao;
import com.soft.domain.Photo;
import com.soft.domain.Search;
import com.soft.service.PhotoService;

@Transactional
@Service("photoService")
public class PhotoServiceImpl implements PhotoService {
	
	@Autowired
	private PhotoDao photoDao;
	
	@Override
	public int insert(String photoName, Integer userId) {
		Date now = new Date();
		Photo ph = new Photo();
		ph.setPhotoName(photoName);
		ph.setPhotoTitle("test");
		ph.setUserId(userId);
		ph.setCreatDate(now);
		int result = photoDao.insert(ph);
		return result;
	}

	@Override
	public List<Photo> getPhotos(int i, Integer limit,Integer userId) {
		Search s = new Search();
		s.setLimit(limit);
		s.setOffset(i);
		s.setUserId(userId);
		return photoDao.getPhotos(s);
	}

	@Override
	public Photo getPhotoInfo(Integer id) {
		return photoDao.getPhotoInfo(id);
	}

	@Override
	public void updatePhotoInfo(Integer id, String photoTitle, String photoInfo) {
		Photo ph = new Photo();
		ph.setId(id);
		ph.setPhotoTitle(photoTitle);
		ph.setPhotoInfo(photoInfo);
		photoDao.updatePhotoInfo(ph);
	}

	@Override
	public Integer getPhotoCount(Integer userId) {
		// TODO Auto-generated method stub
		return photoDao.getPhotoCount(userId);
	}

}
