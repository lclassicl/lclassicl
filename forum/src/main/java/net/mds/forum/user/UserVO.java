package net.mds.forum.user;

import java.io.Serializable;

import org.apache.commons.codec.digest.DigestUtils;

public class UserVO implements Serializable{
	private int user_no;
	private String user_name;
	private String user_id;
	private String user_nick;
	private String user_pw;
	private int user_level;
	private String user_phone;
	private String user_regdate;
	private String user_email;
	private String user_address;
	private String user_ip;
	private String user_zipcode;
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = DigestUtils.sha512Hex(user_pw);
	}
	public int getUser_level() {
		return user_level;
	}
	public void setUser_level(int user_level) {
		this.user_level = user_level;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_regdate() {
		return user_regdate;
	}
	public void setUser_regdate(String user_regdate) {
		this.user_regdate = user_regdate;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_ip() {
		return user_ip;
	}
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	public String getUser_zipcode() {
		return user_zipcode;
	}
	public void setUser_zipcode(String user_zipcode) {
		this.user_zipcode = user_zipcode;
	}
	@Override
	public String toString() {
		return "UserVO [user_no=" + user_no + ", user_name=" + user_name + ", user_id=" + user_id + ", user_nick="
				+ user_nick + ", user_pw=" + user_pw + ", user_level=" + user_level + ", user_phone=" + user_phone
				+ ", user_regdate=" + user_regdate + ", user_email=" + user_email + ", user_address=" + user_address
				+ ", user_ip=" + user_ip + ", user_zipcode=" + user_zipcode + "]";
	}
}
