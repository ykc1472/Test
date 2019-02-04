package com.dto;

import java.util.List;

public class PagingDTO {
	private int offset;
	private int limit = 3;
	private int totalCount;
	private List<EmpDTO> list;

	public PagingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PagingDTO(int offset, int limit, int totalCount, List<EmpDTO> list) {
		super();
		this.offset = offset;
		this.limit = limit;
		this.totalCount = totalCount;
		this.list = list;
	}

	public PagingDTO(int offset) {
		super();
		this.offset = offset;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<EmpDTO> getList() {
		return list;
	}

	public void setList(List<EmpDTO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "pagingDTO [offset=" + offset + ", limit=" + limit + ", totalCount=" + totalCount + ", list=" + list
				+ "]";
	}

}
