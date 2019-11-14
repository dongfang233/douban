package douban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupDAOMSImpl extends DAOBase implements GroupDAO{

	private static final String CREATE_GROUP_SQL="INSERT INTO Groups VALUES(?,?,?)";
	@Override
	public void insertGroup(Group group) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(CREATE_GROUP_SQL);
			pstm.setString(1, group.getGroupid());
			pstm.setString(2, group.getGroupname());
			pstm.setDate(3, group.getCreatetime());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String UPDATE_GROUP_SQL="UPDATE Groups SET groupid=? ,groupname=? ,createtime=? WHERE groupid=? ";
	@Override
	public void updateGroup(Group group, String groupid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_GROUP_SQL);
			pstm.setString(1, group.getGroupid());
			pstm.setString(2, group.getGroupname());
			pstm.setDate(3, group.getCreatetime());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String DELETE_GROUP_SQL="DELETE FROM Groups WHERE groupid=? ";
	@Override
	public void deleteGroup(String movieid, String groupid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(DELETE_GROUP_SQL);
			pstm.setString(1, groupid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String GET_GROUP_SQL="SELECT * FROM Groups WHERE groupid=? ";
	@Override
	public Group getGroup(String groupid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Group group=new Group();
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(GET_GROUP_SQL);
			pstm.setString(1, groupid);
			rs=pstm.executeQuery();
			rs.next();
			group.setGroupid(rs.getString("groupid"));
			group.setGroupname(rs.getString("groupname"));
			group.setCreatetime(rs.getDate("createtime"));
			rs.close();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return group;
	}

	private static final String SEARCH_GROUP_SQL="SELECT * FROM Groups";
	@Override
	public List<Group> getGroupByC(String sql) {
		List<Group> groups = new ArrayList<Group>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			String finalsql = null;
			if(sql.equals("")){
				finalsql = SEARCH_GROUP_SQL;
			}else{
				finalsql = SEARCH_GROUP_SQL + " WHERE "+sql;
			}
			rs=stmt.executeQuery(finalsql);
			while(rs.next()){
				Group group=new Group();
				group.setGroupid(rs.getString("groupid"));
				group.setGroupname(rs.getString("groupname"));
				group.setCreatetime(rs.getDate("createtime"));
				groups.add(group);								
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return groups;
	}

}
