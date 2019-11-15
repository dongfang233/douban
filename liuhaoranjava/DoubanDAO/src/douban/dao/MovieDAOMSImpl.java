package douban.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class MovieDAOMSImpl extends DAOBase implements MovieDAO{
	
	private static final String CREATE_MOVIE_SQL="INSERT INTO Movie VALUES(?,?,?,?,?,?,?)";
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
			pstm.setDate(4, movie.getDate());
			pstm.setInt(5, movie.getTime());
			pstm.setString(6, movie.getAliasname());
			pstm.setBytes(7, movie.getMoviepicture());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	private static final String UPDATE_MOVIE_SQL="UPDATE Movie SET movieid=? ,moviename=? ,language=? ,releasetime=? ,filmlength=?,alias=? ,moviepicture=?  WHERE movieid=? ";
	@Override
	public void updateMovie(Movie movie,String movieid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_MOVIE_SQL);
			pstm.setString(1, movie.getMovieid());
			pstm.setString(2, movie.getMoviename());
			pstm.setString(3, movie.getLanguage());
			pstm.setDate(4, movie.getDate());
			pstm.setInt(5, movie.getTime());
			pstm.setString(6, movie.getAliasname());
			pstm.setBytes(7, movie.getMoviepicture());
			pstm.setString(8, movieid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		
	}
	
	private static final String DELETE_MOVIE_SQL="DELETE FROM Movie WHERE movieid=? ";
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

	private static final String GET_MOVIE_SQL="SELECT * FROM Movie WHERE movieid=? ";
	@Override
	public Movie getMovie(String movieid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		Movie movie=new Movie();
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(GET_MOVIE_SQL);
			pstm.setString(1, movieid);
			ResultSet rs=pstm.executeQuery();
			rs.next();
			movie.setMovieid(rs.getString("movieid"));
			movie.setMoviename(rs.getString("moviename"));
			movie.setLanguage(rs.getString("language"));
			movie.setDate(rs.getDate("releasetime"));
			movie.setTime(rs.getInt("filmlength"));
			movie.setAliasname(rs.getString("alias"));
			movie.setMoviepicture(rs.getBytes("moviepicture"));
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
					movie.setLanguage(rs.getString("language"));
					movie.setDate(rs.getDate("releasetime"));
					movie.setTime(rs.getInt("filmlength"));
					movie.setAliasname(rs.getString("alias"));
					movie.setMoviepicture(rs.getBytes("moviepicture"));
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
	//Provide movieid,moviename,releasetime,filmlength sort
	public List<Movie> getSortByC(String fun,String asc_des) {
		List<Movie> movies=new ArrayList<Movie>();
		MovieDAO moviedao=DAOFactory.getMovieDAO();
		movies=moviedao.getMovieByC("");
		switch(fun) {
		case "movieid":
			Collections.sort(movies, new Comparator<Movie>() {
				public int compare(Movie m1, Movie m2) {
					if(null == m1.getMovieid()) 
						return -1;
					if(null == m2.getMovieid()) 
						return 1;
					return m1.getMovieid().compareTo(m2.getMovieid());
				}
			}
					);
			if(asc_des.equals("des"))
				Collections.reverse(movies);
			break;
		case "moviename":
			Collections.sort(movies, new Comparator<Movie>() {
				public int compare(Movie m1, Movie m2) {
					if(null == m1.getMoviename()) 
						return -1;
					if(null == m2.getMoviename()) 
						return 1;
					return m1.getMoviename().compareTo(m2.getMoviename());
				}
			}
					);
			if(asc_des.equals("des"))
				Collections.reverse(movies);
			break;
		case "releasetime":
			Collections.sort(movies, new Comparator<Movie>() {
				public int compare(Movie m1, Movie m2) {
					if(null == m1.getDate()) 
						return -1;
					if(null == m2.getDate()) 
						return 1;
					return m1.getDate().compareTo(m2.getDate());
				}
			}
					);
			if(asc_des.equals("des"))
				Collections.reverse(movies);
			break;
		case "filmlength":
			Collections.sort(movies, new Comparator<Movie>() {
				public int compare(Movie m1, Movie m2) {
					/*if(null == m1.getTime()) 
						return -1;
					if(null == m2.getTime()) 
						return 1;*/
					if(m1.getTime()>=(m2.getTime()))
						return 1;
					return 0;
				}
			}
					);
			if(asc_des.equals("des"))
				Collections.reverse(movies);
			break;
			
			
		}
		
		return movies;
	}
	//avg star
	public List<Movie> getSortByAvg(String asc_des){
		List<Movie> movies=new ArrayList<Movie>();
		MovieDAO moviedao=DAOFactory.getMovieDAO();
		movies=moviedao.getMovieByC("");
		List<AvgStarSort> avgstarsorts=new ArrayList<AvgStarSort>();
		Iterator<Movie> it=movies.iterator();
		while(it.hasNext()) {
			Movie movie=it.next();
			AvgStarSort avgstarsort=new AvgStarSort();
			avgstarsort.setMovie(movie);
			CommentDAO commentdao=DAOFactory.getCommentDAO();
			avgstarsort.setAvgstar(commentdao.showAvgStar(movie.getMoviename()));
			avgstarsorts.add(avgstarsort);
		}
		Collections.sort(avgstarsorts,new Comparator<AvgStarSort>(){
			public int compare(AvgStarSort o1, AvgStarSort o2) {
				if(o1.getAvgstar()>=o2.getAvgstar()) {
					return 1;
				}else {
					return 0;
				}
			}
		});
		if(asc_des.equals("des")) {
			Collections.reverse(avgstarsorts);
		}
		movies.clear();
		Iterator<AvgStarSort> it1=avgstarsorts.iterator();
		while(it.hasNext()) {
			AvgStarSort avgstarsort=it1.next();
			movies.add(avgstarsort.getMovie());
		}
		return movies;
	}
	//getMovie between start and end
	public List<Movie> getDateMovie(Date start,Date end){
		List<Movie> movies=new ArrayList<Movie>();
		List<Movie> temp=new ArrayList<Movie>();
		MovieDAO moviedao=DAOFactory.getMovieDAO();
		temp=moviedao.getMovieByC("");
		for(Movie m:temp) {
			if(m.getDate().before(end)||m.getDate().after(start)) {
				movies.add(m);
			}
		}
		return movies;
	}
}