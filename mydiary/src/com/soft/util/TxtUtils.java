package com.soft.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.soft.domain.Diary;

public class TxtUtils {
	
	public static void CreateTxtDTS(String fileName,List<Diary> data,String realPath){
		String filePath = realPath;//生成文件路径和文件名
		String file = realPath+fileName+".txt";//生成文件路径和文件名
		try {
			File filename = new File(file);
			 if (!filename.exists()) {
				 filename.createNewFile();
			 }else{
				 deleteFile(filePath,fileName+".txt");
			 }
			 
			 StringBuffer buf = new StringBuffer();
				
				for(Diary di : data){
					buf.append(DateUtil.Date2Str(di.getCreatDate()));
					buf.append("\r\n");
					buf.append(di.getContent());
					buf.append("\r\n");
					buf.append("\r\n");
				}
				FileOutputStream fos = null;
				PrintWriter pw = null;
				try {
					fos = new FileOutputStream(file);
					pw = new PrintWriter(fos);
					pw.write(buf.toString().toCharArray());
					pw.flush();
					
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					if (pw != null) {
						 pw.close();
					}
					if (fos != null) {
						 fos.close();
					}
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void backInser(String fileName,Diary data,String realPath){//每次新增时追加
		BufferedReader bufr = null;
		try {
			File file = new File(realPath + fileName +".txt");
			FileReader fie = new FileReader(file);
			bufr = new BufferedReader(fie);
			String tem = null;
			StringBuffer buf = new StringBuffer();
			while((tem = bufr.readLine()) != null){
				buf.append(tem+"\r\n");
			}
			bufr.close();
			if(buf != null){
				buf.insert(0, data.getContent()+"\r\n\r\n");
				buf.insert(0, DateUtil.Date2Str(data.getCreatDate())+"\r\n");
				saveback(fileName,realPath,buf);
			}
		} catch (Exception e) {
			
		}
	}
	public static void saveback(String fileName,String realPath,StringBuffer buf){
		String filePath = realPath;//生成文件路径和文件名
		String file = realPath+fileName+".txt";//生成文件路径和文件名
		FileOutputStream fos = null;
		PrintWriter pw = null;
		try {
			File filename = new File(file);
			 if (!filename.exists()) {
				 filename.createNewFile();
			 }else{
				 deleteFile(filePath,fileName+".txt");
			 }
			 
			 try {
				 fos = new FileOutputStream(file);
				 pw = new PrintWriter(fos);
				 pw.write(buf.toString().toCharArray());
				 pw.flush();
			} catch (Exception e) {
				
			}finally{
				if (pw != null) {
					 pw.close();
				}
				if (fos != null) {
					 fos.close();
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void deleteFile(String filePath,String fileName){
		File file = new File(filePath);
		if(file.exists()){
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if(files[i].isFile()){
					if(files[i].getName().equals(fileName)){
						files[i].delete();
						return;
					}
				}
			}
		}
	} 
	public static void exportTxt(HttpServletResponse response,String userId,String fileName){
		
        try {
        	response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
			response.addHeader("Content-disposition", "attachment;filename=" + new String(userId.getBytes("GBK"),"ISO8859-1")+".txt");
			InputStream inputStream = new FileInputStream(new File(fileName+userId+".txt"));
			
			OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
             // 关闭。
            os.close();
            inputStream.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
            e.printStackTrace();
        }
	}
}
