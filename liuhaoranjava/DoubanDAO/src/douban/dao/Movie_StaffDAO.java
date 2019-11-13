package douban.dao;

import java.util.List;

public interface Movie_StaffDAO {
	public void insertMovie_Staff(Movie_Staff movie_staff);
	public void updateMovie_Staff(Movie_Staff movie_staff,String movieid,String staffid);
	public void deleteMovie_Staff(String movieid,String staffid);
	public Movie_Staff getMovie_Staff(String movieid,String staffid);
	public List<Movie_Staff> getMovie_StaffByC(String sql);
}
