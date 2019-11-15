package douban.dao;

import java.sql.Date;

public class Message {
	private String messageid;
	private String userid;
	private String messagerid;
	private String messagetext;
	Date messagetime;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getMessageid() {
		return messageid;
	}
	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}
	public String getMessagerid() {
		return messagerid;
	}
	public void setMessagerid(String messagerid) {
		this.messagerid = messagerid;
	}
	public String getMessagetext() {
		return messagetext;
	}
	public void setMessagetext(String messagetext) {
		this.messagetext = messagetext;
	}
	public Date getMessagetime() {
		return messagetime;
	}
	public void setMessagetime(Date messagetime) {
		this.messagetime = messagetime;
	}
}
