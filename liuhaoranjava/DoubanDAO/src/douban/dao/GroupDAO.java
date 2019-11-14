package douban.dao;

import java.util.List;

public interface GroupDAO{
	public void insertGroup(Group group);
	public void updateGroup(Group group,String groupid);
	public void deleteGroup(String movieid,String groupid);
	public Group getGroup(String groupid);
	public List<Group> getGroupByC(String sql);
}
