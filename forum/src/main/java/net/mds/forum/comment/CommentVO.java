package net.mds.forum.comment;

import java.io.Serializable;

public class CommentVO implements Serializable{
	private int com_no;
	private String com_content;
	private String com_regdate;
	private int com_good;
	private int com_bad;
	private int art_no;
	private int user_no;
	private String user_nick;
	public int getCom_no() {
		return com_no;
	}
	public void setCom_no(int com_no) {
		this.com_no = com_no;
	}
	public String getCom_content() {
		return com_content;
	}
	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}
	public String getCom_regdate() {
		return com_regdate;
	}
	public void setCom_regdate(String com_regdate) {
		this.com_regdate = com_regdate;
	}
	public int getCom_good() {
		return com_good;
	}
	public void setCom_good(int com_good) {
		this.com_good = com_good;
	}
	public int getCom_bad() {
		return com_bad;
	}
	public void setCom_bad(int com_bad) {
		this.com_bad = com_bad;
	}
	public int getArt_no() {
		return art_no;
	}
	public void setArt_no(int art_no) {
		this.art_no = art_no;
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
		return "CommentVO [com_no=" + com_no + ", com_content=" + com_content + ", com_regdate=" + com_regdate
				+ ", com_good=" + com_good + ", com_bad=" + com_bad + ", art_no=" + art_no + ", user_no=" + user_no
				+ ", user_nick=" + user_nick + "]";
	}
}
