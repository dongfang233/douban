package douban.test;
import douban.dao.*;

public class getone {

	public static void main(String[] args) {
		String userid=null;
		String movieid=null;
		User user=DAOFactory.getUserDAO().getUser(userid);
		System.out.println("userid="+user.getUserid()+" username="+user.getUsername()+" password="+user.getPassword()+" phonenum="+user.getPhonenum()+" email="+user.getEmail()+" usertype="+user.getUsertype());
		Movie movie=DAOFactory.getMovieDAO().getMovie(movieid);
		System.out.println("movieid="+movie.getMovieid()+" moviename="+movie.getMoviename()+" language="+movie.getLanguage()+" date="+movie.getDate()+" time="+movie.getTime()+" aliasname="+movie.getAliasname()+" moviepicture="+movie.getMoviepicture());
	}

}
