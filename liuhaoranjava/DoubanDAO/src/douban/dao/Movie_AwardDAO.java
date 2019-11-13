package douban.dao;

import java.util.List;

public interface Movie_AwardDAO {
	public void insertMovie_Award(Movie_Award movie_award);
	public void updateMovie_Award(Movie_Award movie_award,String movieid,String awardid);
	public void deleteMovie_Award(String movieid,String awardid);
	public List<Movie_Award> getMovie_AwardByC(String sql);
}