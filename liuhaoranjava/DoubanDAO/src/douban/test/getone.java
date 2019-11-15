package douban.test;
import douban.dao.*;

public class getone {

	public static void main(String[] args) {
		String userid=null;
		String movieid=null;
		DAOFactory.getUserDAO().getUser(userid);
		DAOFactory.getMovieDAO().getMovie(movieid);
	}

}
