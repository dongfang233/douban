package douban.dao;

import java.util.List;

public interface UserDAO {
	public void insertUser(User user);
	public void updateUser(User user,String userid);
	public void deleteUser(String userid);
	public User getUser(String userid);
	public List<User> getUserByC(String sql);
}
