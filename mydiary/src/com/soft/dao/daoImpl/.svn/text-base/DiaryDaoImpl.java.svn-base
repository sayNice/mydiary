package com.soft.dao.daoImpl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.soft.dao.DiaryDao;
import com.soft.domain.Diary;
import com.soft.domain.Search;

@Repository(value="diaryDao")
public class DiaryDaoImpl extends SqlMapClientDaoSupport implements DiaryDao {

	@Override
	public List<Diary> getDiary(Search parameter) {
		@SuppressWarnings("unchecked")
		List<Diary> diary = this.getSqlMapClientTemplate().queryForList("diary.getDiary",parameter);
		return diary;
	}

	@Override
	public void deldiary(Long rowId) {
		/*this.getSqlMapClientTemplate().delete("diary.deldiary",rowId);*/
		this.getSqlMapClientTemplate().update("diary.updateValid",rowId);
	}

	@Override
	public void addDiary(Diary diary) {
		this.getSqlMapClientTemplate().insert("diary.addDiary",diary);
	}

	@Override
	public int getCount(Search s) {
		Integer count= (Integer) this.getSqlMapClientTemplate().queryForObject("diary.getCount",s);
		return count;
	}

	@Override
	public Diary getDiaryById(Long rowId) {
		Diary result = (Diary) this.getSqlMapClientTemplate().queryForObject("diary.getDiaryById",rowId);
		return result;
	}

	@Override
	public void editDiary(Diary diary) {
		this.getSqlMapClientTemplate().update("diary.editDiary",diary);
		
	}

	@Override
	public int getTempDiaryCount(Integer userId) {
		int result = (Integer) this.getSqlMapClientTemplate().queryForObject("diary.getTempDiaryCount",userId);
		return result;
	}

	@Override
	public void tempAdd(Diary diary) {
		this.getSqlMapClientTemplate().insert("diary.tempAdd",diary);
	}

	@Override
	public Diary getTempDiary(Integer userId) {
		Diary result = (Diary) this.getSqlMapClientTemplate().queryForObject("diary.getTempDiary",userId);
		return result;
	}

	@Override
	public void addDiaryForTemp(Diary diary) {
		this.getSqlMapClientTemplate().insert("diary.addDiaryForTemp",diary);
		
	}

	@Override
	public void delTempDiary(Integer userId) {
		this.getSqlMapClientTemplate().delete("diary.delTempDiary",userId);
		
	}

	@Override
	public List<Diary> getAllDiary(Integer userId) {
		List<Diary> result = this.getSqlMapClientTemplate().queryForList("diary.getAllDiary",userId);
		return result;
	}

	@Override
	public List<Diary> getAllDiaryForExprot() {
		List<Diary> result = this.getSqlMapClientTemplate().queryForList("diary.getAllDiaryForExprot");
		return result;
	}

}
