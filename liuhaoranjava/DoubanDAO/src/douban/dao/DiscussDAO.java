package douban.dao;

import java.util.List;

public interface DiscussDAO {
	public void insertDiscuss(Discuss discuss);
	public void updateDiscuss(Discuss discuss,String id);
	public void deleteDiscuss(String discussid);
	public Discuss getDiscuss(String discussid);
	public List<Discuss> getDiscussByC(String sql);
}