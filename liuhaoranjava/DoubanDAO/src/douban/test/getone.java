package douban.test;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import douban.dao.*;

public class getone {

	public static void main(String[] args) {
		String userid=null;
		String movieid=null;
		Format f=new SimpleDateFormat("yyyy-MM-dd");
		Calendar c=Calendar.getInstance();
		User user=DAOFactory.getUserDAO().getUser(userid);
		System.out.println("userid="+user.getUserid()+" username="+user.getUsername()+" password="+user.getPassword()+" phonenum="+user.getPhonenum()+" email="+user.getEmail()+" usertype="+user.getUsertype());
		Movie movie=DAOFactory.getMovieDAO().getMovie(movieid);
		c.setTime(movie.getDate());
		c.add(Calendar.DAY_OF_MONTH, 2);
		System.out.println("movieid="+movie.getMovieid()+" moviename="+movie.getMoviename()+" language="+movie.getLanguage()+" date="+f.format(c.getTime())+" time="+movie.getTime()+" aliasname="+movie.getAliasname()+" moviepicture="+movie.getMoviepicture());
	}

}
