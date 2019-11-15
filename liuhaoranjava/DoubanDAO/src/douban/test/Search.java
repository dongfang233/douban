package douban.test;
import java.util.*;
import douban.dao.*;
public class Search {

	static void Print_User(String sql) {
		List<User> users=new ArrayList<User>();
		users=DAOFactory.getUserDAO().getUserByC(sql);
		Iterator<User> it=users.iterator();
		while(it.hasNext()) {
			User user=it.next();
			System.out.println("userid="+user.getUserid()+" username="+user.getUsername()+" password="+user.getPassword()+" phonenum="+user.getPhonenum()+" email="+user.getEmail()+" usertype="+user.getUsertype());
		}
	}
	static void Print_Movie(String sql) {
		List<Movie> movies=new ArrayList<Movie>();
		movies=DAOFactory.getMovieDAO().getMovieByC("");
		Iterator<Movie> it=movies.iterator();
		while(it.hasNext()) {
			Movie movie=it.next();
			System.out.println("movieid="+movie.getMovieid()+" moviename="+movie.getMoviename()+" language="+movie.getLanguage()+" date="+movie.getDate()+" time="+movie.getTime()+" aliasname="+movie.getAliasname()+" moviepicture="+movie.getMoviepicture());
		}
	}
	public static void main(String[] args) {
		//Search
		Print_User("");
		
		Print_Movie("");
		
		//search label="fantasy" movie information
		Print_Movie("movieid=any(select movieid from Movie_Label where labelid="
				+ "any(select labelid from Label where labelname='fantasy'))");
	}

}
