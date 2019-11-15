package douban.dao;

import java.util.List;

public interface DiscussDAO {
	public void insertDiscuss(Discuss discuss);
	public void updateDiscuss(Discuss discuss,String discussid);
	public void deleteDiscuss(String discussid);
	public Discuss getDiscuss(String discussid);
	public List<Discuss> getDiscussByC(String sql);
	public List<Discuss> getSortByC(String asc_des);
	public Discuss getMaxReply(String moviename);
}