package com.soft.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.soft.author.Constants;
import com.soft.author.SessionInfo;
import com.soft.domain.BgImage;
import com.soft.domain.Diary;
import com.soft.domain.Search;
import com.soft.service.DiaryService;
import com.soft.service.UserService;
import com.soft.util.JsonUtil;
import com.soft.util.TxtUtils;

@Controller
public class DiaryController {
	@Autowired
	private DiaryService diaryService;
	@Autowired
	private UserService userService;
	
	private static Integer limit = 6;
	
	@RequestMapping("toDiaryPage")
	public String toDiaryPage(Search search,HttpServletRequest request,HttpSession session){
		SessionInfo user =(SessionInfo) session.getAttribute(Constants.USER_SESSION);
		Integer userId = user.getId();
		BgImage bg = new BgImage();
		if(userId == 42){
			bg.setAddBg("addbg22.png");
			bg.setViewBg("ali2.jpg");
			bg.setBg1("ali3.jpg");
			bg.setBg2("ali4.jpg");
			bg.setBg3("ali5.jpg");
		}else if(userId == 41){
			bg.setAddBg("zhang/newbg.jpg");
			bg.setViewBg("zhang/viewbg.jpg");
			bg.setBg1("zhang/zbg1.jpg");
			bg.setBg2("zhang/zbg2.jpg");
			bg.setBg3("zhang/zbg3.jpg");
			bg.setBg4("zhang/zbg4.jpg");
		}
		
		Integer currentPage = null;
		if(search != null){
			currentPage = search.getOffset();
		}
		
		Integer offset = 0;
		if(currentPage == null || currentPage == 0){
			offset = 0;
			currentPage = 1;
		}else{
			offset = currentPage*limit - limit;
		}
		search.setUserId(userId);
		search.setLimit(limit);
		search.setOffset(offset);
		List<Diary> result2 = diaryService.getDiary(search);
		int totals= diaryService.getCount(search);
		int totalPage = totals%limit==0?totals/limit:totals/limit+1;
		request.setAttribute("bgs",bg);
		request.setAttribute("writeList", result2);
		request.setAttribute("pageSize", limit);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totals", totals);
		return "diary/WriteList";
	}
	/*@ResponseBody
	@RequestMapping("diarySearch")
	public String diarySearch(HttpSession session,String tilte,String createDate1,String createDate2, Integer limit,Integer offset,HttpServletRequest request){
		PageDTO<Diary> result = new PageDTO<Diary>();
		SessionInfo user =(SessionInfo) session.getAttribute(Constants.USER_SESSION);
		Integer userId = user.getId();
		List<Diary> result2 = diaryService.getDiary(userId,tilte,createDate1,createDate2,limit,offset);
		int totals= diaryService.getCount(userId,tilte,createDate1,createDate2);
		result.setRows(result2);
		result.setTotal(totals);
		return JsonUtil.toJson(result2);
	}*/
	
	@RequestMapping("ExportText")
	public String ExportText(HttpSession session,HttpServletResponse response,HttpServletRequest request){
		SessionInfo user =(SessionInfo) session.getAttribute(Constants.USER_SESSION);
		Integer userId = user.getId();
		String realPath = userService.getRealPath();//获取相对路径
		TxtUtils.exportTxt(response,String.valueOf(userId),realPath);
		return null;
	}
	
	@ResponseBody
	@RequestMapping("deldiary")
	public String deldiary(HttpSession session,Long rowId,HttpServletRequest request){
		diaryService.deldiary(rowId);
		Gson gson = new Gson();
		String json = gson.toJson("删除成功！");
		return json;
	}
	/**
	 * 新增
	 * @param session
	 * @param diary
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addDiary")
	public String addDiary(HttpSession session,String context,String title,HttpServletRequest request){
		SessionInfo user =(SessionInfo) session.getAttribute(Constants.USER_SESSION);
		Integer userId = user.getId();
		Diary diary = new Diary();
		diary.setUserId(userId);
		diary.setTitle(title);
		diary.setContent(context);
		diaryService.addDiary(diary);
		return JsonUtil.toJson("true");
	}
	/**
	 * 跳转到新增页面
	 * @return
	 */
	@RequestMapping("newAddDiary")
	public String newAddDiary(){
		return "diary/addDiary";
	}
	@ResponseBody
	@RequestMapping(value="editDiary")
	public String editDiary(HttpSession session,Long rowId,HttpServletRequest request, HttpServletResponse response){
		Diary result= diaryService.getDiaryById(rowId);
		Gson gson = new Gson();
		String json = gson.toJson(result);
		return json;
	}
	
	@RequestMapping("editDiarys")
	public String editDiary(HttpSession session,Diary diary,HttpServletRequest request){
		diaryService.editDiary(diary);
		return "diary/WriteList";
	}
	@ResponseBody
	@RequestMapping(value="tempAdd")
	public String tempAdd(HttpSession session,String title,String content,HttpServletRequest request){
		
		SessionInfo user =(SessionInfo) session.getAttribute(Constants.USER_SESSION);
		Integer userId = user.getId();
		
		Diary diary = new Diary();
		diary.setUserId(userId);
		diary.setTitle(title);
		diary.setContent(content);
		boolean result= diaryService.tempAdd(diary);
		if(result){
			return "1";
		}else{
			return "2";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="checkTempDiay")
	public String checkTempDiay(HttpSession session){
		
		SessionInfo user =(SessionInfo) session.getAttribute(Constants.USER_SESSION);
		Integer userId = user.getId();
		Diary result= diaryService.checkTempDiay(userId);
		if(result == null){
			return "1";
		}else{
			Gson gson = new Gson();
			String json = gson.toJson(result);
			return json;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="addTemp")
	public String addTemp(HttpSession session,String title,String content,HttpServletRequest request){
		
		SessionInfo user =(SessionInfo) session.getAttribute(Constants.USER_SESSION);
		Integer userId = user.getId();
		
		Diary diary = new Diary();
		diary.setUserId(userId);
		diary.setTitle(title);
		diary.setContent(content);
		boolean result = diaryService.addDiaryForTemp(diary);
		if(result){
			return "1";
		}else{
			return "2";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="clearTemp")
	public String clearTemp(HttpSession session){
		SessionInfo user =(SessionInfo) session.getAttribute(Constants.USER_SESSION);
		Integer userId = user.getId();
		
		diaryService.clearTemp(userId);
		return "1";
	}
	
	@ResponseBody
	@RequestMapping(value="getAllDiary")
	public String getAllDiary(HttpSession session){
		SessionInfo user =(SessionInfo) session.getAttribute(Constants.USER_SESSION);
		Integer userId = user.getId();
		
		String s = diaryService.getAllDiary(userId);
		return s;
	}
	
	@RequestMapping(value="lxj")
	public String tolxj(HttpSession session){
		return "diary/nicepage";
	}
	
	@RequestMapping(value="yh")
	public String toyh(HttpSession session){
		return "diary/nicepageT";
	}
}
