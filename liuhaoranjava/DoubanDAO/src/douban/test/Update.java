package douban.test;
import douban.dao.*;
import java.util.*;
public class Update {

	public static void main(String[] args) {
		//user
		String userid=null;
		User user=new User();
		user.setUserid("1733256");
		user.setUsername("liwang");
		user.setPassword("123456");
		user.setPhonenum("15623238572");
		user.setEmail("123.163.com");
		user.setUsertype(1);
		//movie
		String movieid=null;
		Movie movie=new Movie();
		movie.setMovieid("9263");
		movie.setMoviename("ciaer");
		movie.setLanguage("English");
		movie.setDate((java.sql.Date)(new Date(1998-12-03)));
		movie.setTime(122);
		movie.setAliasname("ciaero");
		movie.setMoviepicture(new byte[1]);
		//update
		DAOFactory.getUserDAO().updateUser(user,userid);
		DAOFactory.getMovieDAO().updateMovie(movie,movieid);
	}

}