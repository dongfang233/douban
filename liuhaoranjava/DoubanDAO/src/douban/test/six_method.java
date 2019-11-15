package douban.test;
import java.sql.Date;

import douban.dao.*;
public class six_method {

	public static void main(String[] args) {
		final String asc_des="asc";
		final String moviename=null;
		//avg star
		DAOFactory.getCommentDAO().showAvgStar(moviename);
		
		//discuss sort
		DAOFactory.getDiscussDAO().getSortByC(moviename, asc_des);
		//discuss max follow
		DAOFactory.getDiscussDAO().getMaxReply(moviename);
		//movie sort
		String fun=moviename;
		DAOFactory.getMovieDAO().getSortByC(fun, asc_des);
		//sort by star
		DAOFactory.getMovieDAO().getSortByAvg(asc_des);
		//get date movie
		Date start=new Date(1001-1-1);
		Date end=new Date(2020-1-1);
		DAOFactory.getMovieDAO().getDateMovie(start, end);
	}

}
