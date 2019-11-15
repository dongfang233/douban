package douban.test;
import douban.dao.*;
import java.util.*;
public class Add {

	public static void main(String[] args) {
		User user=new User();
		user.setUserid("");
		DAOFactory.getUserDAO().insertUser(user);

	}

}
