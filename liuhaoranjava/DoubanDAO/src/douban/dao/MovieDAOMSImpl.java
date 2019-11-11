package douban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MovieDAOMSImpl extends DAOBase implements MovieDAO{
	
	private static final String CREATE_MOVIE_SQL="INSERT INTO Movies VALUES(?,?,?,?,?,?)";
	@Override
	public void insertMovie(Movie movie) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(CREATE_MOVIE_SQL);
			pstm.setString(1, movie.getMovieid());
			pstm.setString(2, movie.getMoviename());
			pstm.setString(3, movie.getLanguage());
			pstm.setString(4, movie.getDate());
			pstm.setInt(5, movie.getTime());
			pstm.setString(6, movie.getAliasname());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	private static final String UPDATE_MOVIE_SQL="UPDATE Movie SET movieid=\'?\',moviename=\'?\',language=\'?\',date=\'?\',time=?,date=\'aliasname\'";
	@Override
	public void updateMovie(Movie movie) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_MOVIE_SQL);
			pstm.setString(1, movie.getMovieid());
			pstm.setString(2, movie.getMoviename());
			pstm.setString(3, movie.getLanguage());
			pstm.setString(4, movie.getDate());
			pstm.setInt(5, movie.getTime());
			pstm.setString(6, movie.getAliasname());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		
	}
	
	private static final String DELETE_MOVIE_SQL="DELETE FROM Movie WHERE movieid=\'?\'";
	@Override
	public void deleteMovie(String movieid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(DELETE_MOVIE_SQL);
			pstm.setString(1, movieid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String GET_USER_SQL="SELECT * FROM Movie WHERE username=\'?\'";
	@Override
	public Movie getMovie(String movieid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		Movie movie=new Movie();
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(GET_USER_SQL);
			pstm.setString(1, movieid);
			ResultSet rs=pstm.executeQuery();
			rs.next();
			movie.setMovieid(rs.getString("movieid"));
			movie.setMoviename(rs.getString("moviename"));
			movie.setLanguage(rs.getString("language;"));
			movie.setDate(rs.getString("date"));
			movie.setTime(rs.getInt("time"));
			movie.setAliasname(rs.getString("aliasname"));
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return movie;	
	}
	
	private static final String SEARCH_MOVIE_SQL="SELECT * FROM Movie";
	@Override
	public List<Movie> getMovieByC(String sql) {
			List<Movie> movies = new ArrayList<Movie>();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try{
				conn = getConnection();
				stmt = conn.createStatement();
				String finalsql = null;
				if(sql.equals("")){
					finalsql = SEARCH_MOVIE_SQL;
				}else{
					finalsql = SEARCH_MOVIE_SQL + " WHERE "+sql;
				}
				rs=stmt.executeQuery(finalsql);
				while(rs.next()){
					Movie movie = new Movie();
					movie.setMovieid(rs.getString("movieid"));
					movie.setMoviename(rs.getString("moviename"));
					movie.setLanguage(rs.getString("language;"));
					movie.setDate(rs.getString("date"));
					movie.setTime(rs.getInt("time"));
					movie.setAliasname(rs.getString("aliasname"));
					movies.add(movie);							
				}
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return movies;
	}

}
