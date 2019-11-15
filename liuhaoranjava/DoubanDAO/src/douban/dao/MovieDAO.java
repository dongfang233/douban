package douban.dao;

import java.sql.Date;
import java.util.List;

public interface MovieDAO {
	public void insertMovie(Movie movie);
	public void updateMovie(Movie movie,String movieid);
	public void deleteMovie(String movieid);
	public Movie getMovie(String movieid);
	public List<Movie> getMovieByC(String sql);
	public List<Movie> getSortByC(String fun,String asc_des);
	public List<Movie> getSortByAvg(String asc_des);
	public List<Movie> getDateMovie(Date start,Date end);
}
