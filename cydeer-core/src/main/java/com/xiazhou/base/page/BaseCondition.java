package com.xiazhou.base.page;

import java.io.Serializable;

/**
 * Created by zhangsong on 15/11/16.
 */
public class BaseCondition implements Serializable {

	public static final int DEFAULT_PAGE_SIZE = 10;

	private Integer totalSize;
	private Integer pageSize = DEFAULT_PAGE_SIZE;
	private Integer page = 1;
	private Integer start = 0;

	public Integer getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}
}
