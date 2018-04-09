package com.soft.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class Import {
	public static void upload(@RequestParam(value="file",required=false) MultipartFile file,HttpServletRequest request,String nowName){
		System.out.println("开始");
		String fileName=file.getOriginalFilename();
		String prefix = fileName.substring(fileName.lastIndexOf(".")+1);
		String path=request.getSession().getServletContext().getRealPath("/")+"upload/"+nowName+"."+prefix;
		String path2 = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/photo/";
		System.out.println("path2==="+path2);
		System.out.println("path===="+path);
		System.out.println("basepath==="+basePath);
		
		System.out.println(fileName);
		
		File targetFile = new File(path);
		if(!targetFile.getParentFile().exists()){
			targetFile.getParentFile().mkdirs();
		}
		try{
			file.transferTo(targetFile);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
