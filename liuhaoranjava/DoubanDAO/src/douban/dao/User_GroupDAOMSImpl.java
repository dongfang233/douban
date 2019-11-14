package douban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class User_GroupDAOMSImpl extends DAOBase implements User_GroupDAO{

	private static final String CREATE_USER_GROUP_SQL="INSERT INTO Users_Groups VALUES(?,?,?,?)";
	@Override
	public void insertUser_Group(User_Group user_group) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(CREATE_USER_GROUP_SQL);
			pstm.setString(1, user_group.getUserid());
			pstm.setString(2, user_group.getGroupid());
			pstm.setString(3, user_group.getLeader());
			pstm.setString(4, user_group.getJointime());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String UPDATE_USER_GROUP_SQL="UPDATE Users_Groups SET userid=? ,groupid=? ,rolename=? ,position=?  WHERE userid=?  and groupid=? ";
	@Override
	public void updateUser_Group(User_Group user_group, String userid, String groupid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_USER_GROUP_SQL);
			pstm.setString(1, user_group.getUserid());
			pstm.setString(2, user_group.getGroupid());
			pstm.setString(3, user_group.getLeader());
			pstm.setString(4, user_group.getJointime());
			pstm.setString(5, userid);
			pstm.setString(6, groupid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_USER_GROUP_SQL="DELETE FROM Users_Groups WHERE userid=?  and groupid=? ";
	@Override
	public void deleteUser_Group(String userid, String groupid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(DELETE_USER_GROUP_SQL);
			pstm.setString(1, userid);
			pstm.setString(2, groupid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String GET_USER_GROUP_SQL="SELECT * FROM Users_Groups WHERE userid=?  and groupid=? ";
	@Override
	public User_Group getUser_Group(String userid, String groupid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		User_Group user_group=new User_Group();
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(GET_USER_GROUP_SQL);
			pstm.setString(1, userid);
			pstm.setString(2, groupid);
			ResultSet rs=pstm.executeQuery();
			rs.next();
			user_group.setUserid(rs.getString("userid"));
			user_group.setGroupid(rs.getString("groupid"));
			user_group.setLeader(rs.getString("leader"));
			user_group.setJointime(rs.getString("jointime"));
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return user_group;	
	}

	private static final String SEARCH_USER_GROUP_SQL="SELECT * FROM Users_Groups";
	@Override
	public List<User_Group> getUser_GroupByC(String sql) {
		List<User_Group> user_groups = new ArrayList<User_Group>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			String finalsql = null;
			if(sql.equals("")){
				finalsql = SEARCH_USER_GROUP_SQL;
			}else{
				finalsql = SEARCH_USER_GROUP_SQL + " WHERE "+sql;
			}
			rs=stmt.executeQuery(finalsql);
			while(rs.next()){
				User_Group user_group=new User_Group();
				user_group.setUserid(rs.getString("userid"));
				user_group.setGroupid(rs.getString("groupid"));
				user_group.setLeader(rs.getString("leader"));
				user_group.setJointime(rs.getString("jointime"));
				user_groups.add(user_group);				
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return user_groups;
	}

}
