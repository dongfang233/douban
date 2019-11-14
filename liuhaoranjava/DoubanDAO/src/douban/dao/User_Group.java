package douban.dao;

import java.sql.Date;

public class User_Group {
	private String userid;
	private String groupid;
	private String leader;
	private Date jointime;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public Date getJointime() {
		return jointime;
	}
	public void setJointime(Date jointime) {
		this.jointime = jointime;
	}
	
}
