package douban.test;
import java.sql.Date;

import douban.dao.*;
public class six_method {

	public static void main(String[] args) {
		//avg star
		String moviename=null;
		DAOFactory.getCommentDAO().showAvgStar(moviename);
		
		//discuss sort
		
		//discuss max follow
		
		//movie sort
		String fun=moviename;
		String asc_des="asc";
		DAOFactory.getMovieDAO().getSortByC(fun, asc_des);
		//sort by star
		DAOFactory.getMovieDAO().getSortByAvg(asc_des);
		//get date movie
		Date start=new Date(1001-1-1);
		Date end=new Date(2020-1-1);
		DAOFactory.getMovieDAO().getDateMovie(start, end);
	}

}
