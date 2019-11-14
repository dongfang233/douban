package douban.dao;

import java.util.List;

public interface StagephotoDAO {
	public void insertStagephoto(Stagephoto stagephoto);
	public void updateStagephoto(Stagephoto stagephoto,String stagephotoid);
	public void deleteStagephoto(String stagephotoid);
	public Stagephoto getStagephoto(String stagephotoid);
	public List<Stagephoto> getStagephotoByC(String sql);
}
