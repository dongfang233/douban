package douban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Movie_LabelDAOMSImpl extends DAOBase implements Movie_LabelDAO{

	private static final String CREATE_MOVIE_LABEL_SQL="INSERT INTO Movie_Label VALUES(?,?,?)";
	@Override
	public void insertMovie_Label(Movie_Label movie_label) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(CREATE_MOVIE_LABEL_SQL);
			pstm.setString(1, movie_label.getMovieid());
			pstm.setString(2, movie_label.getLabelid());
			pstm.setInt(3, movie_label.getCounts());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String UPDATE_MOVIE_LABEL_SQL="UPDATE Movie_Label SET movieid=\'?\',labelid=\'?\',counts=? WHERE movieid=\'?\' and labelid=\'?\'";
	@Override
	public void updateMovie_Label(Movie_Label movie_label, String movieid, String labelid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_MOVIE_LABEL_SQL);
			pstm.setString(1, movie_label.getMovieid());
			pstm.setString(2, movie_label.getLabelid());
			pstm.setInt(3, movie_label.getCounts());
			pstm.setString(4, movieid);
			pstm.setString(5, labelid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_MOVIE_LABEL_SQL="DELETE FROM Movie_Label WHERE movieid=\'?\' and labelid=\'?\'";
	@Override
	public void deleteMovie_Label(String movieid, String labelid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(DELETE_MOVIE_LABEL_SQL);
			pstm.setString(1, movieid);
			pstm.setString(2, labelid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String GET_MOVIE_LABEL_SQL="SELECT * FROM Movie_Label WHERE movieid=\'?\' and labelid=\'?\'";
	@Override
	public Movie_Label getMovie_Label(String movieid, String labelid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		Movie_Label movie_label=new Movie_Label();
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(GET_MOVIE_LABEL_SQL);
			pstm.setString(1, movieid);
			pstm.setString(2, labelid);
			ResultSet rs=pstm.executeQuery();
			rs.next();
			movie_label.setMovieid(rs.getString("movieid"));
			movie_label.setLabelid(rs.getString("labelid"));
			movie_label.setCounts(rs.getInt("counts"));
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return movie_label;	
	}

	private static final String SEARCH_MOVIE_LABEL_SQL="SELECT * FROM Movie_Staff";
	@Override
	public List<Movie_Label> getMovie_LabelByC(String sql) {
		List<Movie_Label> movie_labels = new ArrayList<Movie_Label>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			String finalsql = null;
			if(sql.equals("")){
				finalsql = SEARCH_MOVIE_LABEL_SQL;
			}else{
				finalsql = SEARCH_MOVIE_LABEL_SQL + " WHERE "+sql;
			}
			rs=stmt.executeQuery(finalsql);
			while(rs.next()){
				Movie_Label movie_label=new Movie_Label();
				movie_label.setMovieid(rs.getString("movieid"));
				movie_label.setLabelid(rs.getString("labelid"));
				movie_label.setCounts(rs.getInt("counts"));
				movie_labels.add(movie_label);			
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return movie_labels;
	}

}
