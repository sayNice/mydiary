package com.soft.service;

import java.util.List;

import com.soft.domain.Photo;

public interface PhotoService {
	int insert(String photoName,Integer userId);

	List<Photo> getPhotos(int i, Integer limit, Integer userId);

	Photo getPhotoInfo(Integer id);

	void updatePhotoInfo(Integer id, String photoTitle, String photoInfo);

	Integer getPhotoCount(Integer userId);
}
