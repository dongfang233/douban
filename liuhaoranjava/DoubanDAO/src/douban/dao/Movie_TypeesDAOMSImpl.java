package douban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Movie_TypeesDAOMSImpl extends DAOBase implements Movie_TypeesDAO{

	private static final String CREATE_MOVIE_TYPEES_SQL="INSERT INTO Movie_Typees VALUES(?,?)";
	@Override
	public void insertMovie_Typees(Movie_Typees movie_typees) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(CREATE_MOVIE_TYPEES_SQL);
			pstm.setString(1, movie_typees.getMovieid());
			pstm.setString(2, movie_typees.getTypeid());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_MOVIE_TYPEES_SQL="UPDATE Movie_Typees SET movieid=\'?\',typeid=\'?\' WHERE movieid=\'?\' and typeid=\'?\'";
	@Override
	public void updateMovie_Typees(Movie_Typees movie_typees, String movieid,String typeid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_MOVIE_TYPEES_SQL);
			pstm.setString(1, movie_typees.getMovieid());
			pstm.setString(2, movie_typees.getTypeid());
			pstm.setString(3, movieid);
			pstm.setString(4, typeid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_MOVIE_TYPEES_SQL="DELETE FROM Movie_Typees WHERE movieid=\'?\' and typeid=\'?\'";
	@Override
	public void deleteMovie_Typees(String movieid,String typeid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(DELETE_MOVIE_TYPEES_SQL);
			pstm.setString(1, movieid);
			pstm.setString(2, typeid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String SEARCH_MOVIE_TYPEES_SQL="SELECT * FROM Movie_Typees";
	@Override
	public List<Movie_Typees> getMovie_TypeesByC(String sql) {
		List<Movie_Typees> Movie_Typees = new ArrayList<Movie_Typees>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			String finalsql = null;
			if(sql.equals("")){
				finalsql = SEARCH_MOVIE_TYPEES_SQL;
			}else{
				finalsql = SEARCH_MOVIE_TYPEES_SQL + " WHERE "+sql;
			}
			rs=stmt.executeQuery(finalsql);
			while(rs.next()){
				Movie_Typees movie_type = new Movie_Typees();
				movie_type.setMovieid(rs.getString("movieid"));
				movie_type.setTypeid(rs.getString("typeid"));	
				Movie_Typees.add(movie_type);									
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return Movie_Typees;
	}
	
}
