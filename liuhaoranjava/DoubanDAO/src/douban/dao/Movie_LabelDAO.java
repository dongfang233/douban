package douban.dao;

import java.util.List;

public interface Movie_LabelDAO {
	public void insertMovie_Label(Movie_Label movie_label);
	public void updateMovie_Label(Movie_Label movie_label,String movieid,String labelid);
	public void deleteMovie_Label(String movieid,String labelid);
	public Movie_Label getMovie_Label(String movieid,String labelid);
	public List<Movie_Label> getMovie_LabelByC(String sql);
}
