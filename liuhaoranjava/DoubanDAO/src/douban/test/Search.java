package douban.test;
import java.util.*;
import douban.dao.*;
public class Search {

	public static void main(String[] args) {
		//Search
		List<User> users=new ArrayList<User>();
		users=DAOFactory.getUserDAO().getUserByC("");
		Iterator<User> it=users.iterator();
		while(it.hasNext()) {
			User user=it.next();
			System.out.println("userid="+user.getUserid()+" username="+user.getUsername()+" password="+user.getPassword()+" phonenum="+user.getPhonenum()+" email="+user.getEmail()+" usertype="+user.getUsertype());
		}
		
		List<Movie> movies=new ArrayList<Movie>();
		movies=DAOFactory.getMovieDAO().getMovieByC("");
		Iterator<Movie> it1=movies.iterator();
		while(it.hasNext()) {
			Movie movie=it1.next();
			System.out.println("movieid="+movie.getMovieid()+" moviename="+movie.getMoviename()+" language="+movie.getLanguage()+" date="+movie.getDate()+" time="+movie.getTime()+" aliasname="+movie.getAliasname()+" moviepicture="+movie.getMoviepicture());
		}
	}

}
