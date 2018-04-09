package com.soft.util;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.soft.domain.Diary;

public class DiaryAnalysis {
	public static String count = "总字数";
	
	public static String happy = "高兴";
	public static String good = "开心";
	
	public static String sad = "难过";
	public static String hard = "伤心";
	
	public static String like = "喜欢";
	public static String love = "爱";
	
	public static String i = "我";
	public static String you = "你";
	public static String he = "他";
	public static String she = "她";
	
	
	public static Map<String , Integer> analysis(List<Diary> temp){
		Map<String , Integer> result = new TreeMap<String, Integer>();
		Integer counts = 0;
		Integer happys = 0;
		Integer goods = 0;
		Integer sads = 0;
		Integer hards = 0;
		Integer likes = 0;
		Integer loves = 0;
		Integer is = 0;
		Integer yous = 0;
		Integer hes = 0;
		Integer shes = 0;
		if(temp !=null && !temp.isEmpty()){
			for (int j = 0; j < temp.size(); j++) {
				String content = temp.get(j).getContent();
				if(content !=null){
				counts = counts +content.length();
				happys = happys + getCount(content ,happy);
				goods = goods + getCount(content ,good);
				sads = sads + getCount(content ,sad);
				hards = hards + getCount(content ,hard);
				likes = likes + getCount(content ,like);
				loves = loves + getCount(content ,love);
				is = is + getCount(content ,i);
				yous = yous + getCount(content ,you);
				hes = hes + getCount(content ,he);
				shes = shes + getCount(content ,she);
				}
			}
		}
		result.put(count, counts);
		result.put(happy, happys);
		result.put(good, goods);
		result.put(sad, sads);
		result.put(hard, hards);
		result.put(like, likes);
		result.put(love, loves);
		result.put(i, is);
		result.put(you, yous);
		result.put(he, hes);
		result.put(she, shes);
		return result;
	}
	
	
	
	public static Integer getCount(String text , String find){
		Integer cot = 0;
		 Pattern p = Pattern.compile(find);
		    Matcher m = p.matcher(text);
		    while (m.find()) {
		        cot++;
		    }
		return cot;
	}
}
