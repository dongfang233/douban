package douban.dao;

import java.util.List;

public interface AwardDAO {
	public void insertAward(Award award);
	public void updateAward(Award award,String awardid);
	public void deleteAward(String awardid);
	public Award getAward(String awardid);
	public List<Award> getAwardByC(String sql);
}