package com.soft.framework.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.soft.service.DiaryService;
import com.soft.service.UserService;

@Component
public class QuartzCreateTxt {
	@Autowired
	private DiaryService diaryService;
	
	@Autowired
	private UserService userService;
	/**
	 * @Scheduled(cron = "0/60 * * * * *")六十秒执行一次
	 * @Scheduled(cron = "0 0 2 * * ?")每天凌晨两点执行
	 */
	 @Scheduled(cron = "0 0 2 * * ?")
	 public void execute() {  
	        System.out.println("######定时任务执行######"); 
	        diaryService.getAllDiaryForExprot();
	    } 
}
