package com.soft.dao;

import java.util.List;

import com.soft.domain.Diary;
import com.soft.domain.Search;

public interface DiaryDao {

	List<Diary> getDiary(Search parameter);

	void deldiary(Long rowId);

	void addDiary(Diary diary);

	int getCount(Search s);

	Diary getDiaryById(Long rowId);

	void editDiary(Diary diary);

	int getTempDiaryCount(Integer userId);

	void tempAdd(Diary diary);

	Diary getTempDiary(Integer userId);

	void addDiaryForTemp(Diary diary);

	void delTempDiary(Integer userId);

	List<Diary> getAllDiary(Integer userId);

	List<Diary> getAllDiaryForExprot();


}
