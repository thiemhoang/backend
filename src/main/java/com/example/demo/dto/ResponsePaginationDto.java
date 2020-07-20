package com.example.demo.dto;

import java.util.List;

public class ResponsePaginationDto<T> {

	List<T> data;

	private Integer totalPage;
	private Integer rowsPerPage;
	private Integer currentPage;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}


	public Integer getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(Integer rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

}
