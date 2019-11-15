package douban.test;

import douban.dao.*;




public class Delete {

	public static void main(String[] args) {
		//delete
		DAOFactory.getUserDAO().deleteUser("1733256");
		DAOFactory.getMovieDAO().deleteMovie("9263");
	}

}
