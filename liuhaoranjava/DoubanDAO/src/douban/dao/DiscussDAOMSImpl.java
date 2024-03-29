package douban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class DiscussDAOMSImpl extends DAOBase implements DiscussDAO{
	
	private static final String CREATE_DISCUSS_SQL="INSERT INTO Discuss VALUES(?,?,?,?,?,?,?,?)";
	@Override
	public void insertDiscuss(Discuss discuss) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(CREATE_DISCUSS_SQL);
			pstm.setString(1, discuss.getDiscussid());
			pstm.setString(2, discuss.getGroupid());
			pstm.setString(3, discuss.getMovieid());
			pstm.setString(4, discuss.getUserid());
			pstm.setString(5, discuss.getTitle());
			pstm.setString(6,discuss.getSubtance());
			pstm.setDate(7, discuss.getWritetime());
			pstm.setString(8, discuss.getFatherid());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	private static final String UPDATE_DISCUSS_SQL="UPDATE Discuss SET discussid=? ,groupid=? ,"
			+ "movieid=? ,userid=? ,title=? ,subtance=? ,writetime=? ,fatherid=?  where discussid=? ";
	@Override
	public void updateDiscuss(Discuss discuss,String discussid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_DISCUSS_SQL);
			pstm.setString(1, discuss.getDiscussid());
			pstm.setString(2, discuss.getGroupid());
			pstm.setString(3, discuss.getMovieid());
			pstm.setString(4, discuss.getUserid());
			pstm.setString(5, discuss.getTitle());
			pstm.setString(6,discuss.getSubtance());
			pstm.setDate(7, discuss.getWritetime());
			pstm.setString(8, discuss.getFatherid());
			pstm.setString(9, discussid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		
	}

	private static final String DELETE_DISCUSS_SQL="DELETE FROM Discuss WHERE discussid=? ";
	@Override
	public void deleteDiscuss(String discussid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(DELETE_DISCUSS_SQL);
			pstm.setString(1, discussid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String GET_DISCUSS_SQL="SELECT * FROM Discuss WHERE discussid=? ";
	@Override
	public Discuss getDiscuss(String discussid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		Discuss discuss=new Discuss();
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(GET_DISCUSS_SQL);
			pstm.setString(1, discussid);
			ResultSet rs=pstm.executeQuery();
			rs.next();
			discuss.setDiscussid(rs.getString("discussid"));
			discuss.setGroupid(rs.getString("groupid"));
			discuss.setMovieid(rs.getString("movieid"));
			discuss.setUserid(rs.getString("userid"));
			discuss.setTitle(rs.getString("title"));
			discuss.setSubtance(rs.getString("subtance"));
			discuss.setWritetime(rs.getDate("writetime"));
			discuss.setFatherid(rs.getString("fatherid"));
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return discuss;	
	}
	
	private static final String SEARCH_DISCUSS_SQL="SELECT * FROM Discuss";
	@Override
	public List<Discuss> getDiscussByC(String sql) {
			List<Discuss> discusses = new ArrayList<Discuss>();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try{
				conn = getConnection();
				stmt = conn.createStatement();
				String finalsql = null;
				if(sql.equals("")){
					finalsql = SEARCH_DISCUSS_SQL;
				}else{
					finalsql = SEARCH_DISCUSS_SQL + " WHERE "+sql;
				}
				rs=stmt.executeQuery(finalsql);
				while(rs.next()){
					Discuss discuss = new Discuss();
					discuss.setDiscussid(rs.getString("discussid"));
					discuss.setGroupid(rs.getString("groupid"));
					discuss.setMovieid(rs.getString("movieid"));
					discuss.setUserid(rs.getString("userid"));
					discuss.setTitle(rs.getString("title"));
					discuss.setSubtance(rs.getString("subtance"));
					discuss.setWritetime(rs.getDate("writetime"));
					discuss.setFatherid(rs.getString("fatherid"));
					discusses.add(discuss);							
				}
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return discusses;
	}
	
	public List<Discuss> getSortByC(String moviename,String asc_des) {
		Movie movie=new Movie();
		List<Movie> movies = new ArrayList<Movie>();
		MovieDAO moviedao=DAOFactory.getMovieDAO();
		movies=moviedao.getMovieByC("moviename="+moviename);
		if(movies.get(0)==null) {
			return null;//not found
		}else { //finded
			movie=movies.get(0);
			String movieid=movie.getMovieid();
			List<Discuss> discusses=new ArrayList<Discuss>();
			DiscussDAO discussdao=DAOFactory.getDiscussDAO();
			discusses=discussdao.getDiscussByC("movieid="+movieid);
			Collections.sort(discusses, new Comparator<Discuss>() {
			public int compare(Discuss m1, Discuss m2) {
				if(null == m1.getWritetime()) 
					return -1;
				if(null == m2.getWritetime()) 
					return 1;
				return m1.getWritetime().compareTo(m2.getWritetime());
				}
			}
					);
			if(asc_des.equals("des"))
				Collections.reverse(discusses);
			
			return discusses;
		}
	}

	private static final int N=10000;
	public Discuss getMaxReply(String moviename) {
		Movie movie=new Movie();
		List<Movie> movies = new ArrayList<Movie>();
		MovieDAO moviedao=DAOFactory.getMovieDAO();
		movies=moviedao.getMovieByC("moviename="+moviename);
		if(movies.get(0)==null) {
			return null;//not found
		}else { //finded
			movie=movies.get(0);
			String movieid=movie.getMovieid();
			List<Discuss> discusses=new ArrayList<Discuss>();
			DiscussDAO discussdao=DAOFactory.getDiscussDAO();
			discusses=discussdao.getDiscussByC("movieid="+movieid);
			int []a=new int[N];
			Iterator<Discuss> it=discusses.iterator();
			while(it.hasNext()) {
			Discuss discuss=it.next();
			if(discuss.fatherid!=null) {
				a[Integer.valueOf(discuss.fatherid)]++;
				}
			}
			int max=0;
			for(int i=0;i<N;i++) {
				if(a[i]>max)
				{
					max=i;
				}
			}
			Discuss discuss=new Discuss();
			discuss=discussdao.getDiscuss(String.valueOf(max));
			return discuss;
		}
	}
}
