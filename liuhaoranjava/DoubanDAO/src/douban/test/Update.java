package douban.test;
import douban.dao.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Update {

	public static void main(String[] args) throws ParseException {
		//user
		String userid=null;
		User user=new User();
		user.setUserid("1733256");
		user.setUsername("liwang");
		user.setPassword("123456");
		user.setPhonenum("15623238572");
		user.setEmail("123.163.com");
		user.setUsertype(1);
		userid="812";
		//movie
		String movieid=null;
		Movie movie=new Movie();
		movie.setMovieid("9263");
		movie.setMoviename("ciaer");
		movie.setLanguage("English");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date=sdf.parse("1999-08-12");
		long lg=date.getTime();
		movie.setDate(new java.sql.Date(lg));
		movie.setTime(122);
		movie.setAliasname("ciaero");
		movie.setMoviepicture(new byte[1]);
		movieid="812";
		//update
		DAOFactory.getUserDAO().updateUser(user,userid);
		DAOFactory.getMovieDAO().updateMovie(movie,movieid);
	}

}