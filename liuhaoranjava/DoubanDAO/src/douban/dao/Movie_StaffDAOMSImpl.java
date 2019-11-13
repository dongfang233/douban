package douban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Movie_StaffDAOMSImpl extends DAOBase implements Movie_StaffDAO{

	private static final String CREATE_MOVIE_STAFF_SQL="INSERT INTO Movie_Staff VALUES(?,?,?,?)";
	@Override
	public void insertMovie_Staff(Movie_Staff movie_staff) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(CREATE_MOVIE_STAFF_SQL);
			pstm.setString(1, movie_staff.getMovieid());
			pstm.setString(2, movie_staff.getUserid());
			pstm.setString(3, movie_staff.getRolename());
			pstm.setString(4, movie_staff.getPosition());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String UPDATE_MOVIE_STAFF_SQL="UPDATE Movie_Staff SET movieid=\'?\',staffid=\'?\',rolename=\'?\',position=\'?\' WHERE movieid=\'?\' and staffid=\'?\'";
	@Override
	public void updateMovie_Staff(Movie_Staff movie_staff, String movieid, String staffid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_MOVIE_STAFF_SQL);
			pstm.setString(1, movie_staff.getMovieid());
			pstm.setString(2, movie_staff.getUserid());
			pstm.setString(3, movie_staff.getRolename());
			pstm.setString(4, movie_staff.getPosition());
			pstm.setString(5, movieid);
			pstm.setString(6, staffid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_MOVIE_STAFF_SQL="DELETE FROM Movie_Staff WHERE movieid=\'?\' and staffid=\'?\'";
	@Override
	public void deleteMovie_Staff(String movieid, String staffid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(DELETE_MOVIE_STAFF_SQL);
			pstm.setString(1, movieid);
			pstm.setString(2, staffid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String GET_MOVIE_STAFF_SQL="SELECT * FROM Movie_Staff WHERE movieid=\'?\' and staffid=\'?\'";
	@Override
	public Movie_Staff getMovie_Staff(String movieid, String staffid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		Movie_Staff movie_staff=new Movie_Staff();
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(GET_MOVIE_STAFF_SQL);
			pstm.setString(1, movieid);
			pstm.setString(2, staffid);
			ResultSet rs=pstm.executeQuery();
			rs.next();
			movie_staff.setMovieid(rs.getString("movieid"));
			movie_staff.setUserid(rs.getString("staffid"));
			movie_staff.setRolename(rs.getString("rolename"));
			movie_staff.setPosition(rs.getString("position"));
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return movie_staff;	
	}

	private static final String SEARCH_MOVIE_STAFF_SQL="SELECT * FROM Movie_Staff";
	@Override
	public List<Movie_Staff> getMovie_StaffByC(String sql) {
		List<Movie_Staff> movie_staffs = new ArrayList<Movie_Staff>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			String finalsql = null;
			if(sql.equals("")){
				finalsql = SEARCH_MOVIE_STAFF_SQL;
			}else{
				finalsql = SEARCH_MOVIE_STAFF_SQL + " WHERE "+sql;
			}
			rs=stmt.executeQuery(finalsql);
			while(rs.next()){
				Movie_Staff movie_staff=new Movie_Staff();
				movie_staff.setMovieid(rs.getString("movieid"));
				movie_staff.setUserid(rs.getString("staffid"));
				movie_staff.setRolename(rs.getString("rolename"));
				movie_staff.setPosition(rs.getString("position"));
				movie_staffs.add(movie_staff);				
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return movie_staffs;
	}

}
