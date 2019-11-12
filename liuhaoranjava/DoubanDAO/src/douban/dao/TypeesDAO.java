package douban.dao;
import java.util.List;
public interface TypeesDAO {
		public void insertTypees(Typees typees);
		public void updateTypees(Typees typees,String typeesid);
		public void deleteTypees(String typeesid);
		public List<Typees> getTypees(String typeesid);
		public List<Typees> getTypeesByC(String sql);
	
}
