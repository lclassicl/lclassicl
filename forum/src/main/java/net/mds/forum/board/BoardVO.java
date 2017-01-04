package net.mds.forum.board;

import java.io.Serializable;

public class BoardVO implements Serializable{
	private int boa_no;
	private String boa_name;
	private String boa_url;
	private int boa_level;
	private String boa_type;
	private int user_no;
	
	public int getBoa_no() {
		return boa_no;
	}
	public void setBoa_no(int boa_no) {
		this.boa_no = boa_no;
	}
	public String getBoa_name() {
		return boa_name;
	}
	public void setBoa_name(String boa_name) {
		this.boa_name = boa_name;
	}
	public String getBoa_url() {
		return boa_url;
	}
	public void setBoa_url(String boa_url) {
		this.boa_url = boa_url;
	}
	public int getBoa_level() {
		return boa_level;
	}
	public void setBoa_level(int boa_level) {
		this.boa_level = boa_level;
	}
	public String getBoa_type() {
		return boa_type;
	}
	public void setBoa_type(String boa_type) {
		this.boa_type = boa_type;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	@Override
	public String toString() {
		return "BoardVO [boa_no=" + boa_no + ", boa_name=" + boa_name + ", boa_url=" + boa_url + ", boa_level="
				+ boa_level + ", boa_type=" + boa_type + ", user_no=" + user_no + "]";
	}
}
