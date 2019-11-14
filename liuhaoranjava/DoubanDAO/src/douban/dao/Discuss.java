package douban.dao;

import java.sql.Date;

public class Discuss {
	String discussid;
	String groupid;
	String movieid;
	String userid;
	String title;
	String subtance;
	Date writetime;
	String fatherid;
	public String getDiscussid() {
		return discussid;
	}
	public void setDiscussid(String discussid) {
		this.discussid = discussid;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getMovieid() {
		return movieid;
	}
	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtance() {
		return subtance;
	}
	public void setSubtance(String subtance) {
		this.subtance = subtance;
	}
	public Date getWritetime() {
		return writetime;
	}
	public void setWritetime(Date writetime) {
		this.writetime = writetime;
	}
	public String getFatherid() {
		return fatherid;
	}
	public void setFatherid(String fatherid) {
		this.fatherid = fatherid;
	}
}
