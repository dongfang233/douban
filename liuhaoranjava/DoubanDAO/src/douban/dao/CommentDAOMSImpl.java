package douban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommentDAOMSImpl extends DAOBase implements CommentDAO{

	private static final String CREATE_COMMENT_SQL="INSERT INTO Comment VALUES(?,?,?,?,?)";
	@Override
	public void insertComment(Comment comment) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(CREATE_COMMENT_SQL);
			pstm.setString(1, comment.getMovieid());
			pstm.setString(2, comment.getUserid());
			pstm.setString(3, comment.getBriefcomment());
			pstm.setInt(4, comment.getStarnum());
			pstm.setString(5, comment.getType());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String UPDATE_COMMENT_SQL="UPDATE Comment SET movieid=?,userid=?,briefcomment=? ,starnum=? ,type=? where movieid=? and userid=?";
	@Override
	public void updateComment(Comment comment, String movieid, String userid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_COMMENT_SQL);
			pstm.setString(1, comment.getMovieid());
			pstm.setString(2, comment.getUserid());
			pstm.setString(3, comment.getBriefcomment());
			pstm.setInt(4, comment.getStarnum());
			pstm.setString(5, comment.getType());
			pstm.setString(6, movieid);
			pstm.setString(7, userid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String DELETE_COMMENT_SQL="DELETE FROM Comment WHERE movieid=? and userid=?";
	@Override
	public void deleteComment(String movieid, String userid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(DELETE_COMMENT_SQL);
			pstm.setString(1, movieid);
			pstm.setString(2, userid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String GET_COMMENT_SQL="SELECT * FROM Comment WHERE movieid=? and userid=?";
	@Override
	public Comment getComment(String movieid, String userid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		Comment comment=new Comment();
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(GET_COMMENT_SQL);
			pstm.setString(1, movieid);
			pstm.setString(2, userid);
			ResultSet rs=pstm.executeQuery();
			rs.next();
			comment.setMovieid(rs.getString("movieid"));
			comment.setUserid(rs.getString("userid"));
			comment.setBriefcomment(rs.getString("briefcomment"));
			comment.setStarnum(rs.getInt("starnum"));
			comment.setType(rs.getString("type"));
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return comment;	
	}

	private static final String SEARCH_COMMENT_SQL="SELECT * FROM Comment";
	@Override
	public List<Comment> getCommentByC(String sql) {
		List<Comment> comments = new ArrayList<Comment>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			String finalsql = null;
			if(sql.equals("")){
				finalsql = SEARCH_COMMENT_SQL;
			}else{
				finalsql = SEARCH_COMMENT_SQL + " WHERE "+sql;
			}
			rs=stmt.executeQuery(finalsql);
			while(rs.next()){
				Comment comment=new Comment();
				comment.setMovieid(rs.getString("movieid"));
				comment.setUserid(rs.getString("userid"));
				comment.setBriefcomment(rs.getString("briefcomment"));
				comment.setStarnum(rs.getInt("starnum"));
				comment.setType(rs.getString("type"));
				comments.add(comment);					
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return comments;
	}
	
	public int showAvgStar(String moviename) {
		int avgstar=0;
		//Connection conn=null;
		Movie movie=new Movie();
		List<Movie> movies = new ArrayList<Movie>();
		MovieDAO moviedao=DAOFactory.getMovieDAO();//new MovieDAOMSImpl();
		movies=moviedao.getMovieByC("moviename="+moviename);
		if(movies.get(0)==null) {
			//not found
		}else { //finded
			movie=movies.get(0);
			String movieid=movie.getMovieid();
			List<Comment> comments=new ArrayList<Comment>();
			CommentDAO commentdao=DAOFactory.getCommentDAO();
			comments=commentdao.getCommentByC("movieid="+movieid);
			if(comments.get(0)==null) {
				//no star
			}else {
				Iterator<Comment> it=comments.iterator();
				int i=0;
				while(it.hasNext()) {
					Comment comment=new Comment();
					comment=it.next();
					avgstar+=comment.getStarnum();
					i++;
				}
				avgstar/=i;
			}
		}
		return avgstar;
	}
}
