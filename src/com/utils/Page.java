package com.utils;

import java.util.List;

public class Page<T> {
    
	private int total;     //所有客户总数量
	private int page;      //当前页
	private int size;     //页码总数
    private List<T> rows;  //每页包含的客户的数据
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "Page{" +
				"total=" + total +
				", page=" + page +
				", size=" + size +
				", rows=" + rows +
				'}';
	}
}
