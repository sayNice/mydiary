package com.soft.framework.interceptors;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.soft.author.SessionInfo;

public class SecurityInterceptor implements HandlerInterceptor {
	private List<String> excludeUrls;//����Ҫ���ص���Դ

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}
	/**
	 * ���ҳ���render�����
	 */
	
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object object
			,Exception exception)throws Exception{
		
	}
	/**
	 * �ڵ���controller���巽��������
	 */
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
			ModelAndView modelAndView) throws Exception {

	}
	/**
	 * �ڵ���controller���巽��ǰ����
	 */
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String requestUri=request.getRequestURI();
		String contextPath=request.getContextPath();
		String url=requestUri.substring(contextPath.length());
		SessionInfo sessionInfo=(SessionInfo) request.getSession().getAttribute(com.soft.framework.constant.GlobalConstant.SESSION_INFO);
		System.out.println(requestUri);
		System.out.println(contextPath);
		System.out.println(url);
		
		if ((url.indexOf("/admin/") > -1) || excludeUrls.contains(url) || request.getSession().getAttribute("username")!=null) {// ���Ҫ���ʵ���Դ�ǲ���Ҫ��֤��
			return true;
		}
		
		if((sessionInfo ==null) || (sessionInfo.getId()==0)){//���û�е�¼���ߵ�¼��ʱ
			/*if(request.getCookies() != null && request.getCookies().length>1){
				request.getRequestDispatcher("loginUser").forward(request, response);
				return false;
			}else{*/
				System.out.println("session 为空，此URL不能访问");
				request.setAttribute("msg", "请先登录");
				request.getRequestDispatcher("/WEB-INF/jsp/sym/login.jsp").forward(request, response);
				return false;
			//}
			
		}
		return true;
	}
	
}
