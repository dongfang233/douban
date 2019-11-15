package douban.test;
import douban.dao.*;
import java.sql.Date;
public class Add {

	public static void main(String[] args) {
		//User
		User user=new User();
		user.setUserid("812");
		user.setUsername("Accelerator");
		user.setPassword("123");
		user.setPhonenum("12311221234");
		user.setEmail("123@qq.com");
		user.setUsertype(1);
		//Movie
		Movie movie=new Movie();
		movie.setMovieid("812");
		movie.setMoviename("Accelerator");
		movie.setLanguage("english");
		movie.setDate((java.sql.Date)(new Date(1999-06-23)));
		movie.setTime(134);
		movie.setAliasname("Fast Fast");
		byte []buffer=new byte[1024];
		movie.setMoviepicture(buffer);
		//add
		DAOFactory.getUserDAO().insertUser(user);
		DAOFactory.getMovieDAO().insertMovie(movie);

	}

}
