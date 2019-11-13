package douban.dao;

public class Comment {
	private String movieid;
	private String userid;
	private String briefcomment;
	private int starnum;
	private String type;
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
	public String getBriefcomment() {
		return briefcomment;
	}
	public void setBriefcomment(String briefcomment) {
		this.briefcomment = briefcomment;
	}
	public int getStarnum() {
		return starnum;
	}
	public void setStarnum(int starnum) {
		this.starnum = starnum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
