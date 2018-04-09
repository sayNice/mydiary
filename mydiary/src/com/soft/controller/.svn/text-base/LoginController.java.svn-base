package com.soft.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soft.author.Constants;
import com.soft.author.SessionInfo;
import com.soft.domain.User;
import com.soft.service.UserService;



@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="toLogin")
	public String tologin(HttpServletRequest request){
		return "sym/login";
	}
	
	@RequestMapping(value="loginUser")
	public String loginUser(User user,HttpSession session,HttpServletRequest request,HttpServletResponse response){
		/*Cookie[] cookie = request.getCookies();
		if(cookie.length > 1){
			user.setUsername(cookie[1].getValue());
			user.setPassword(cookie[2].getValue());
		}*/
		User us;
		if(userService.checklogin(user)){
			us=userService.getuser(user.getUsername());
			SessionInfo sessionInfo=new SessionInfo();
			SimpleDateFormat sd = new SimpleDateFormat("yy/MM/dd HH:mm");
			sessionInfo.setName(us.getName());
			sessionInfo.setCreatedate(us.getCreatedate());
			sessionInfo.setId(us.getId());
			sessionInfo.setUsername(us.getUsername());
			sessionInfo.setNiceName(us.getNiceName());
			
			String filePath = request.getSession().getServletContext().getRealPath("/")+"backups\\";//生成文件路径和文件名
			userService.saveRealPath(filePath);//项目路径插入到路径表中
			if(us.getLastLoginTime()!=null){
				sessionInfo.setLastLoginTime(sd.format(us.getLastLoginTime()));
			}
			/*sessionInfo.setResourceList(userService.getResource(us.getId()));*/
			session.setAttribute(Constants.USER_SESSION,sessionInfo);
			/*if(cookie.length<=1){
				Cookie cookieUsername = new Cookie(Constants.USER_COOKIE, user.getUsername());
				cookieUsername.setMaxAge(172800); // 秒为单位 48h
				cookieUsername.setPath("/");
			    response.addCookie(cookieUsername);
			    
				Cookie cookiePassword = new Cookie(Constants.USER_COOKE_PASSWORD, us.getPassword());
				cookiePassword.setMaxAge(172800); // 秒为单位 48h
				cookiePassword.setPath("/");
			    response.addCookie(cookiePassword);
			}*/
			userService.updateLastLoginTime(us.getId());
			return "redirect:toDiaryPage";
			
		}
		request.setAttribute("msg", "登录失败");
		return "sym/login";
	}
	@RequestMapping(value="outloginUser")
	public String outloginUser(HttpServletRequest request, HttpSession session,HttpServletResponse response){
		/*Cookie[] cookies = request.getCookies();
		for(int i = 0 ; i < cookies.length ; i++){
			if(cookies[i].getName().equals(Constants.USER_COOKIE) || cookies[i].getName().equals(Constants.USER_COOKE_PASSWORD)){
				cookies[i].setValue(null);
                cookies[i].setPath("/");
                cookies[i].setMaxAge(0);
                response.addCookie(cookies[i]);
			}
		}*/
		session.removeAttribute("username");
		request.setAttribute("msg", "注销成功");
		return "sym/login";
	}
	@RequestMapping(value="/registUser")
	@ResponseBody
	public String registUser(HttpServletRequest request,User user){
		return userService.registUser(user);
		
	}
	
	@RequestMapping("editUser")
	public String editUser(HttpSession session,User user,HttpServletRequest request){
		SessionInfo user2 =(SessionInfo) session.getAttribute(Constants.USER_SESSION);
		Integer userId = user2.getId();
		user.setId(userId);
		boolean cot = userService.editUser(user);
		if(cot){
			session.removeAttribute("username");
			request.setAttribute("msg", "修改成功，请重新登录！");
			return "sym/login";
		}else{
			request.setAttribute("msg", "修改失败，请稍候重试。");
			return "diary/WriteList";
		}
	}
	
	/*@RequestMapping(value="upload")
	public String upload(@RequestParam(value="file",required=false) MultipartFile file,HttpServletRequest request, ModelMap model){
		FileUtil.upload(file,request,model);
		return "account/result";
	}
	@RequestMapping(value="download")
	public String download(String fileName, HttpServletRequest request,HttpServletResponse response){
		com.soft.util.download.download(fileName, request, response);
		return "account/login1";
	}*/
}
