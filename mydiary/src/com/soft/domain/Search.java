package com.soft.domain;

public class Search {
	private String title;
	private Integer userId;
	private String createDate1;
	private String createDate2;
	private Integer limit;
	private Integer offset;
	
	
	public String getCreateDate1() {
		return createDate1;
	}
	public void setCreateDate1(String createDate1) {
		this.createDate1 = createDate1;
	}
	public String getCreateDate2() {
		return createDate2;
	}
	public void setCreateDate2(String createDate2) {
		this.createDate2 = createDate2;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
	
}
