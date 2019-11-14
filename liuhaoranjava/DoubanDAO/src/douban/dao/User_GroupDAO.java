package douban.dao;

import java.util.List;

public interface User_GroupDAO {
	public void insertUser_Group(User_Group user_group);
	public void updateUser_Group(User_Group user_group,String movieid,String staffid);
	public void deleteUser_Group(String userid,String groupid);
	public User_Group getUser_Group(String userid,String groupid);
	public List<User_Group> getUser_GroupByC(String sql);
}