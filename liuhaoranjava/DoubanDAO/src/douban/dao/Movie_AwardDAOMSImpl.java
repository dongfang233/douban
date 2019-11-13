package douban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Movie_AwardDAOMSImpl extends DAOBase implements Movie_AwardDAO{

	private static final String CREATE_MOVIE_AWARD_SQL="INSERT INTO Movie_Award VALUES(?,?)";
	@Override
	public void insertMovie_Award(Movie_Award movie_award) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(CREATE_MOVIE_AWARD_SQL);
			pstm.setString(1, movie_award.getMovieid());
			pstm.setString(2, movie_award.getAwardid());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_MOVIE_AWARD_SQL="UPDATE Movie_Award SET movieid=\'?\',awardid=\'?\' WHERE movieid=\'?\' and awardid=\'?\'";
	@Override
	public void updateMovie_Award(Movie_Award movie_award, String movieid,String awardid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_MOVIE_AWARD_SQL);
			pstm.setString(1, movie_award.getMovieid());
			pstm.setString(2, movie_award.getAwardid());
			pstm.setString(3, movieid);
			pstm.setString(4, awardid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_MOVIE_AWARD_SQL="DELETE FROM Movie_Award WHERE movieid=\'?\' and awardid=\'?\'";
	@Override
	public void deleteMovie_Award(String movieid,String awardid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(DELETE_MOVIE_AWARD_SQL);
			pstm.setString(1, movieid);
			pstm.setString(2, awardid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String SEARCH_MOVIE_AWARD_SQL="SELECT * FROM Award";
	@Override
	public List<Movie_Award> getMovie_AwardByC(String sql) {
		List<Movie_Award> Movie_Awards = new ArrayList<Movie_Award>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			String finalsql = null;
			if(sql.equals("")){
				finalsql = SEARCH_MOVIE_AWARD_SQL;
			}else{
				finalsql = SEARCH_MOVIE_AWARD_SQL + " WHERE "+sql;
			}
			rs=stmt.executeQuery(finalsql);
			while(rs.next()){
				Movie_Award movie_award = new Movie_Award();
				movie_award.setMovieid(rs.getString("movieid"));
				movie_award.setAwardid(rs.getString("awardid"));	
				Movie_Awards.add(movie_award);									
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return Movie_Awards;
	}
	
}