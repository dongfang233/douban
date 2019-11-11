package douban.dao;

import java.util.List;

public interface UserDAO {
	public void insertUser(User user);
	public void updateUser(User user);
	public void deleteUser(String username);
	public User getUser(String username);
	public List<User> getUserByC(String sql);
}
