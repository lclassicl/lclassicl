package net.mds.forum.board;

import java.io.Serializable;

public class PageSearchVO implements Serializable{
	private int boa_no;
	private long startnum;
	private long endnum;
	private String searchCondition;
	private String searchKeyword;
	
	public int getBoa_no() {
		return boa_no;
	}
	public void setBoa_no(int boa_no) {
		this.boa_no = boa_no;
	}
	public long getStartnum() {
		return startnum;
	}
	public void setStartnum(long startnum) {
		this.startnum = startnum;
	}
	public long getEndnum() {
		return endnum;
	}
	public void setEndnum(long endnum) {
		this.endnum = endnum;
	}
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	@Override
	public String toString() {
		return "PageSearchVO [boa_no=" + boa_no + ", startnum=" + startnum + ", endnum=" + endnum + ", searchCondition="
				+ searchCondition + ", searchKeyword=" + searchKeyword + "]";
	}
}
