package net.mds.forum.board;

import java.io.Serializable;

public class ArticleVO implements Serializable{
	private int art_no;
	private String art_title;
	private String art_content;
	private String art_regdate;
	private int art_readcount;
	private int art_good;
	private int art_bad;
	private int art_comcount;
	private int boa_no;
	private int user_no;
	private String user_nick;
	public int getArt_no() {
		return art_no;
	}
	public void setArt_no(int art_no) {
		this.art_no = art_no;
	}
	public String getArt_title() {
		return art_title;
	}
	public void setArt_title(String art_title) {
		this.art_title = art_title;
	}
	public String getArt_content() {
		return art_content;
	}
	public void setArt_content(String art_content) {
		this.art_content = art_content;
	}
	public String getArt_regdate() {
		return art_regdate;
	}
	public void setArt_regdate(String art_regdate) {
		this.art_regdate = art_regdate;
	}
	public int getArt_readcount() {
		return art_readcount;
	}
	public void setArt_readcount(int art_readcount) {
		this.art_readcount = art_readcount;
	}
	public int getArt_good() {
		return art_good;
	}
	public void setArt_good(int art_good) {
		this.art_good = art_good;
	}
	public int getArt_bad() {
		return art_bad;
	}
	public void setArt_bad(int art_bad) {
		this.art_bad = art_bad;
	}
	public int getArt_comcount() {
		return art_comcount;
	}
	public void setArt_comcount(int art_comcount) {
		this.art_comcount = art_comcount;
	}
	public int getBoa_no() {
		return boa_no;
	}
	public void setBoa_no(int boa_no) {
		this.boa_no = boa_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	@Override
	public String toString() {
		return "ArticleVO [art_no=" + art_no + ", art_title=" + art_title + ", art_content=" + art_content
				+ ", art_regdate=" + art_regdate + ", art_readcount=" + art_readcount + ", art_good=" + art_good
				+ ", art_bad=" + art_bad + ", art_comcount=" + art_comcount + ", boa_no=" + boa_no + ", user_no="
				+ user_no + ", user_nick=" + user_nick + "]";
	}
	
	
}
