package com.soft.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.soft.author.Constants;
import com.soft.author.SessionInfo;
import com.soft.domain.Photo;
import com.soft.domain.Search;
import com.soft.service.PhotoService;
import com.soft.util.Import;
import com.soft.util.JsonUtil;

@Controller
public class PhotoController {
	private static Integer limit = 6;
	
	@Autowired
	private PhotoService photoService;
	
	@RequestMapping("photo")
	public String photo(Search search,HttpServletRequest request,HttpSession session){
		SessionInfo user =(SessionInfo) session.getAttribute(Constants.USER_SESSION);
		Integer userId = user.getId();
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
		
		List<Photo> result = photoService.getPhotos(offset,limit,userId);
		
		String path= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/upload/" ;
		for(Photo photo : result){
			String photourl =path+photo.getPhotoName();
			photo.setUrl(photourl);
			System.out.println(photourl);
		}
		Integer totals = photoService.getPhotoCount(userId);
		
		int totalPage = totals%limit==0?totals/limit:totals/limit+1;
		request.setAttribute("pageSize", limit);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totals", totals);
		request.setAttribute("photoList", result);
		return "photo/myPhoto";
	}
	@ResponseBody
	@RequestMapping(value = "ImportImg", headers = "content-type=multipart/*", method = RequestMethod.POST)
	public String ImportImg(@RequestParam("file") MultipartFile file,HttpServletRequest request,HttpSession session){
		String nowName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		Import.upload(file, request,nowName);
		String fileName=file.getOriginalFilename();
		String prefix = fileName.substring(fileName.lastIndexOf(".")+1);
		String photoName = nowName+"."+prefix;
		System.out.println(photoName);
		SessionInfo user =(SessionInfo) session.getAttribute(Constants.USER_SESSION);
		Integer userId = user.getId();
		photoService.insert(photoName, userId);
		
		return JsonUtil.toJson("true");
	}
	
	@ResponseBody
	@RequestMapping("getPhotoInfo")
	public String getPhotoInfo(Integer id){
		Photo result = photoService.getPhotoInfo(id);
		return JsonUtil.toJson(result);
	}
	@ResponseBody
	@RequestMapping("updatePhotoInfo")
	public String updatePhotoInfo(Integer id,String photoTitle,String photoInfo){
		photoService.updatePhotoInfo(id,photoTitle,photoInfo);
		return JsonUtil.toJson("true");
	}
}
