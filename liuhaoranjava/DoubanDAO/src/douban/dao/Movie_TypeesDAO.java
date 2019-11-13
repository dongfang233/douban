package douban.dao;

import java.util.List;

public interface Movie_TypeesDAO {
	public void insertMovie_Typees(Movie_Typees movie_typees);
	public void updateMovie_Typees(Movie_Typees movie_typees,String movieid,String typeid);
	public void deleteMovie_Typees(String movieid,String typeid);
	public List<Movie_Typees> getMovie_TypeesByC(String sql);
}