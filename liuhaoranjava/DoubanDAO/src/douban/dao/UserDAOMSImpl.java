package douban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDAOMSImpl extends DAOBase implements UserDAO{
	
	private static final String CREATE_USER_SQL="INSERT INTO Users VALUES(?,?,?,?,?)";
	@Override
	public void insertUser(User user) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(CREATE_USER_SQL);
			pstm.setString(1, user.getUsername());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getPhonenum());
			pstm.setString(4, user.getEmail());
			pstm.setInt(5, user.getUsertype());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	private static final String UPDATE_USER_SQL="UPDATE Users SET username=\'?\',password=\'?\',phonenum=\'?\',email=\'?\',usertype=\'?\'";
	@Override
	public void updateUser(User user) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_USER_SQL);
			pstm.setString(1, user.getUsername());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getPhonenum());
			pstm.setString(4, user.getEmail());
			pstm.setInt(5, user.getUsertype());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		
	}
	
	private static final String DELETE_USER_SQL="DELETE FROM Users WHERE username=\'?\'";
	@Override
	public void deleteUser(String username) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(DELETE_USER_SQL);
			pstm.setString(1, username);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String GET_USER_SQL="SELECT * FROM Users WHERE username=\'?\'";
	@Override
	public User getUser(String username) {
		Connection conn = null;
		PreparedStatement pstm = null;
		User user=new User();
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(GET_USER_SQL);
			pstm.setString(1, username);
			ResultSet rs=pstm.executeQuery();
			rs.next();
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
