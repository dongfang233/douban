package douban.dao;

import java.util.List;

public interface MovieDAO {
	public void insertMovie(Movie movie);
	public void updateMovie(Movie movie);
	public void deleteMovie(String movieid);
	public Movie getMovie(String movieid);
	public List<Movie> getMovieByC(String sql);
}
