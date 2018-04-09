package com.soft.util;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @ClassName: PageDTO
 * @Description: TODO 分页 DTO
 * @author
 * @date
 * 
 * @param <T>
 */


@Data
public class PageDTO<T> implements Serializable {

	private static final long serialVersionUID = 1506001471794438107L;
	private Integer total;
	private List<T> rows;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	
}
