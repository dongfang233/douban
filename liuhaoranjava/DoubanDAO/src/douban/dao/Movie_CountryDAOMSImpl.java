package douban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Movie_CountryDAOMSImpl extends DAOBase implements Movie_CountryDAO{

	private static final String CREATE_MOVIE_COUNTRY_SQL="INSERT INTO Movie_Country VALUES(?,?)";
	@Override
	public void insertMovie_Country(Movie_Country movie_country) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(CREATE_MOVIE_COUNTRY_SQL);
			pstm.setString(1, movie_country.getMovieid());
			pstm.setString(2, movie_country.getCountryid());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_MOVIE_AWARD_SQL="UPDATE Movie_Country SET movieid=\'?\',countryid=\'?\' WHERE movieid=\'?\' and countryid=\'?\'";
	@Override
	public void updateMovie_Country(Movie_Country movie_country, String movieid,String countryid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_MOVIE_AWARD_SQL);
			pstm.setString(1, movie_country.getMovieid());
			pstm.setString(2, movie_country.getCountryid());
			pstm.setString(3, movieid);
			pstm.setString(4, countryid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_MOVIE_AWARD_SQL="DELETE FROM Movie_Country WHERE movieid=\'?\' and countryid=\'?\'";
	@Override
	public void deleteMovie_Country(String movieid,String countryid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(DELETE_MOVIE_AWARD_SQL);
			pstm.setString(1, movieid);
			pstm.setString(2, countryid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String SEARCH_MOVIE_AWARD_SQL="SELECT * FROM Movie_Country";
	@Override
	public List<Movie_Country> getMovie_CountryByC(String sql) {
		List<Movie_Country> Movie_Countrys = new ArrayList<Movie_Country>();
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
				Movie_Country movie_country = new Movie_Country();
				movie_country.setMovieid(rs.getString("movieid"));
				movie_country.setCountryid(rs.getString("countryid"));	
				Movie_Countrys.add(movie_country);									
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return Movie_Countrys;
	}
	
}