package douban.dao;

import java.sql.Date;

public class Movie {
	private String moviename;
	private String movieid;
	private String language;
	private Date date;
	private int time;
	private String aliasname;
	private byte[] moviepicture;
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getMovieid() {
		return movieid;
	}
	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getAliasname() {
		return aliasname;
	}
	public void setAliasname(String aliasname) {
		this.aliasname = aliasname;
	}
	public byte[] getMoviepicture() {
		return moviepicture;
	}
	public void setMoviepicture(byte[] moviepicture) {
		this.moviepicture = moviepicture;
	}
	
}
