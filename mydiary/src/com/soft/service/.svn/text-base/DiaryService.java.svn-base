package com.soft.service;

import java.util.List;

import com.soft.domain.Diary;
import com.soft.domain.Search;

public interface DiaryService {

	List<Diary> getDiary(Search search);

	void deldiary(Long rowId);

	void addDiary(Diary diary);

	int getCount(Search search);

	Diary getDiaryById(Long rowId);

	void editDiary(Diary diary);

	boolean tempAdd(Diary diary);

	Diary checkTempDiay(Integer userId);

	boolean addDiaryForTemp(Diary diary);

	void clearTemp(Integer userId);

	String getAllDiary(Integer userId);

	void getAllDiaryForExprot();
	
}
