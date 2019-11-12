package douban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDAOMSImpl extends DAOBase implements UserDAO{
	
	private static final String CREATE_USER_SQL="INSERT INTO Users VALUES(?,?,?,?,?,?)";
	@Override
	public void insertUser(User user) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(CREATE_USER_SQL);
			pstm.setString(1, user.getUserid());
			pstm.setString(2, user.getUsername());
			pstm.setString(3, user.getPassword());
			pstm.setString(4, user.getPhonenum());
			pstm.setString(5, user.getEmail());
			pstm.setInt(6, user.getUsertype());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	private static final String UPDATE_USER_SQL="UPDATE Users SET userid=\'?\',username=\'?\',password=\'?\',phonenum=\'?\',email=\'?\',usertype=\'?\' WHERE userid=\'?\'";
	@Override
	public void updateUser(User user,String userid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_USER_SQL);
			pstm.setString(1, user.getUserid());
			pstm.setString(2, user.getUsername());
			pstm.setString(3, user.getPassword());
			pstm.setString(4, user.getPhonenum());
			pstm.setString(5, user.getEmail());
			pstm.setInt(6, user.getUsertype());
			pstm.setString(7, userid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		
	}
	
	private static final String DELETE_USER_SQL="DELETE FROM Users WHERE userid=\'?\'";
	@Override
	public void deleteUser(String userid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(DELETE_USER_SQL);
			pstm.setString(1, userid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String GET_USER_SQL="SELECT * FROM Users WHERE userid=\'?\'";
	@Override
	public User getUser(String userid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		User user=new User();
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(GET_USER_SQL);
			pstm.setString(1, userid);
			ResultSet rs=pstm.executeQuery();
			rs.next();
			user.setUserid(rs.getString("userid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setPhonenum(rs.getString("phonenum"));
			user.setEmail(rs.getString("email"));
			user.setUsertype(rs.getInt("usertype"));
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;	
	}
	
	private static final String SEARCH_USER_SQL="SELECT * FROM Users";
	@Override
	public List<User> getUserByC(String sql) {
			List<User> users = new ArrayList<User>();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try{
				conn = getConnection();
				stmt = conn.createStatement();
				String finalsql = null;
				if(sql.equals("")){
					finalsql = SEARCH_USER_SQL;
				}else{
					finalsql = SEARCH_USER_SQL + " WHERE "+sql;
				}
				rs=stmt.executeQuery(finalsql);
				while(rs.next()){
					User user = new User();
					user.setUserid(rs.getString("userid"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setPhonenum(rs.getString("phonenum"));
					user.setEmail(rs.getString("email"));
					user.setUsertype(rs.getInt("usertype"));
					users.add(user);							
				}
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return users;
	}

}
