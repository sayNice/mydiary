package com.soft.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soft.dao.DiaryDao;
import com.soft.domain.Diary;
import com.soft.domain.Search;
import com.soft.service.DiaryService;
import com.soft.service.UserService;
import com.soft.util.DiaryAnalysis;
import com.soft.util.TxtUtils;

@Transactional
@Service("diaryService")

public class DiaryServiceImpl implements DiaryService {
	@Autowired
	private DiaryDao diaryDao;
	
	@Autowired
	private UserService userService;
	
	private static int titleLength = 10;//标题默认显示长度
	private static int contentLength = 15;//正文默认显示长度

	@Override
	public List<Diary> getDiary(Search search) {
		
		if(search.getCreateDate1()!= null && search.getCreateDate1()!= ""){
			search.setCreateDate1(search.getCreateDate1()+" 00:00:00");
		}else{
			search.setCreateDate1(null);
		}
		if(search.getCreateDate2() != null && search.getCreateDate2() != ""){
			search.setCreateDate2(search.getCreateDate2()+" 23:59:59");
		}else{
			search.setCreateDate2(null);
		}
		List<Diary> diaryList = diaryDao.getDiary(search);
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		Calendar calendar = Calendar.getInstance(); // 得到日历
		if(diaryList != null && !diaryList.isEmpty()){
			
			for(Diary diary:diaryList){
				String title = diary.getTitle();
				String content = diary.getContent();
				Date date = diary.getCreatDate();
				calendar.setTime(date);
				diary.setDay(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
				
				switch(calendar.get(Calendar.MONTH)+1){
				case 1:
					diary.setMonth("一");
					break;
				case 2:
					diary.setMonth("二");
					break;
				case 3:
					diary.setMonth("三");
					break;
				case 4:
					diary.setMonth("四");
					break;
				case 5:
					diary.setMonth("五");
					break;
				case 6:
					diary.setMonth("六");
					break;
				case 7:
					diary.setMonth("七");
					break;
				case 8:
					diary.setMonth("八");
					break;
				case 9:
					diary.setMonth("九");
					break;
				case 10:
					diary.setMonth("十");
					break;
				case 11:
					diary.setMonth("十一");
					break;
				case 12:
					diary.setMonth("十二");
					break;
				}
				if(title != null && title !=""){
					if(title.length()>=titleLength){
						diary.setTitle(title.substring(0, titleLength)+"...");
					}
				}else{
					if(content.length()>6){
						diary.setTitle(content.substring(0, 6));
					}else{
						diary.setTitle("lovely");
					}
					
				}
				if(content !=null && content != ""){
					if(content.length() >= contentLength){
						diary.setSimpleContent(content.substring(0, contentLength)+"...");
					}else{
						diary.setSimpleContent(content.substring(0, content.length()));
					}
					diary.setContent(content.replaceAll("\n", "<br/>"));
				}
				
				diary.setCreatDateS(df.format(diary.getCreatDate()));
			}
		}
		return diaryList;
	}


	@Override
	public void deldiary(Long rowId) {
		diaryDao.deldiary(rowId);
		
	}


	@Override
	public void addDiary(Diary diary) {
		diary.setCreatDate(new Date());
		if(diary.getTitle() != null && diary.getTitle().trim().equals("41")){
			diary.setUserId(41);
		}
		if(diary.getTitle() != null && diary.getTitle().trim().equals("42")){
			diary.setUserId(42);
		}
		diaryDao.addDiary(diary);
		//添加到TXT文件中
		if(diary.getUserId() == 41 || diary.getUserId() == 42){
			String realPath = userService.getRealPath();//获取相对路径
			TxtUtils.backInser("diary",diary,realPath);
		}
		
	}


	@Override
	public int getCount(Search search) {
		
		if(search.getCreateDate1() != null && search.getCreateDate1() != ""){
			search.setCreateDate1(search.getCreateDate1()+" 00:00:00");
		}
		if(search.getCreateDate2() != null && search.getCreateDate2() != ""){
			search.setCreateDate2(search.getCreateDate2()+" 00:00:00");
		}
		int count= diaryDao.getCount(search);
		return count;
	}


	@Override
	public Diary getDiaryById(Long rowId) {
		Diary result = diaryDao.getDiaryById(rowId);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		result.setCreatDateS(df.format(result.getCreatDate()));
		return result;
	}


	@Override
	public void editDiary(Diary diary) {
		diaryDao.editDiary(diary);
		
	}


	@Override
	public boolean tempAdd(Diary diary) {
		boolean bo = false;
		int cot = diaryDao.getTempDiaryCount(diary.getUserId());
		if(cot<=0){
			diary.setCreatDate(new Date());
			diaryDao.tempAdd(diary);
			bo=true;
		}
		
		return bo;
	}


	@Override
	public Diary checkTempDiay(Integer userId) {
		Diary diary = null;
		int cot = diaryDao.getTempDiaryCount(userId);
		if(cot>0){
		diary = diaryDao.getTempDiary(userId);
		}
		return diary;
	}


	@Override
	public boolean addDiaryForTemp(Diary diary) { 
		boolean result = false;
		diary.setCreatDate(new Date());
		
		if(diary.getTitle() != null && diary.getTitle().trim().equals("41")){
			diary.setUserId(41);
		}
		if(diary.getTitle() != null && diary.getTitle().trim().equals("42")){
			diary.setUserId(42);
		}
		diaryDao.addDiaryForTemp(diary);
		diaryDao.delTempDiary(diary.getUserId());
		
		String realPath = userService.getRealPath();//获取相对路径
		TxtUtils.backInser("diary",diary,realPath);
		result = true;
		return result;
	}


	@Override
	public void clearTemp(Integer userId) {
		diaryDao.delTempDiary(userId);
	}


	@Override
	public String getAllDiary(Integer userId) {
		List<Diary> data =  diaryDao.getAllDiary(userId);
		Map<String , Integer> res = DiaryAnalysis.analysis(data);
		StringBuffer result = new StringBuffer();
		/*Iterator<Map.Entry<String, Integer>> entries = res.entrySet().iterator(); 
		while(entries.hasNext()){
			Map.Entry<String, Integer> entry = entries.next();
			result.append(entry.getKey()+"出现了:"+entry.getValue()+"次、");
		}*/
		result.append(DiaryAnalysis.count+":"+res.get(DiaryAnalysis.count)+"次、<br/>"+
				DiaryAnalysis.happy+"出现了:"+res.get(DiaryAnalysis.happy)+"次、<br/>"+
				DiaryAnalysis.good+"出现了:"+res.get(DiaryAnalysis.good)+"次、<br/>"+
				DiaryAnalysis.sad+"出现了:"+res.get(DiaryAnalysis.sad)+"次、<br/>"+
				DiaryAnalysis.hard+"出现了:"+res.get(DiaryAnalysis.hard)+"次、<br/>"+
				DiaryAnalysis.like+"出现了:"+res.get(DiaryAnalysis.like)+"次、<br/>"+
				DiaryAnalysis.love+"出现了:"+res.get(DiaryAnalysis.love)+"次、<br/>"+
				DiaryAnalysis.i+"出现了:"+res.get(DiaryAnalysis.i)+"次、<br/>"+
				DiaryAnalysis.you+"出现了:"+res.get(DiaryAnalysis.you)+"次、<br/>"+
				DiaryAnalysis.he+"出现了:"+res.get(DiaryAnalysis.he)+"次、<br/>"+
				DiaryAnalysis.she+"出现了:"+res.get(DiaryAnalysis.she)+"次、");
		return result.toString();
	}


	@Override
	public void getAllDiaryForExprot() {//定时任务每天备份数据
		String realPath = userService.getRealPath();//获取相对路径
		List<Diary> datas1 = new ArrayList<Diary>();//me
		List<Diary> datas2 = new ArrayList<Diary>();//she
		List<Diary> datas = diaryDao.getAllDiaryForExprot();

		for(Diary di : datas){
			if(di.getUserId() == 41){
				datas1.add(di);
			}else if(di.getUserId() == 42){
				datas2.add(di);
			}
		}
		//TxtUtils.CreateTxtDTS("diary", datas,realPath);
		TxtUtils.CreateTxtDTS("41", datas1,realPath);
		TxtUtils.CreateTxtDTS("42", datas2,realPath);
		
	}

}
