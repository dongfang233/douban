package douban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MessageDAOMSImpl extends DAOBase implements MessageDAO{

	private static final String CREATE_MESSAGE_SQL="INSERT INTO Message VALUES(?,?,?,?)";
	@Override
	public void insertMessage(Message message) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(CREATE_MESSAGE_SQL);
			pstm.setString(1, message.getUserid());
			pstm.setString(2, message.getMessageid());
			pstm.setString(3, message.getMessagetext());
			pstm.setDate(4, message.getMessagetime());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private static final String UPDATE_MESSAGE_SQL="UPDATE Message SET messageid=? ,messagename=?  WHERE messageid=? ";
	@Override
	public void updateMessage(Message message, String messageid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_MESSAGE_SQL);
			pstm.setString(1, message.getUserid());
			pstm.setString(2, message.getMessageid());
			pstm.setString(3, message.getMessagetext());
			pstm.setDate(4, message.getMessagetime());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String DELETE_MESSAGE_SQL="DELETE FROM Message WHERE messageid=? ";
	@Override
	public void deleteMessage(String messageid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(DELETE_MESSAGE_SQL);
			pstm.setString(1, messageid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String GET_MESSAGE_SQL="SELECT * FROM Message WHERE messageid=? ";
	@Override
	public Message getMessage(String messageid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Message message=new Message();
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(GET_MESSAGE_SQL);
			pstm.setString(1, messageid);
			rs=pstm.executeQuery();
			rs.next();
			message.setUserid(rs.getString("userid"));
			message.setMessageid(rs.getString("messageid"));
			message.setMessagetext(rs.getString("messagetext"));
			message.setMessagetime(rs.getDate("messagetime"));
			rs.close();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return message;
	}

	private static final String SEARCH_MESSAGE_SQL="SELECT * FROM Message";
	@Override
	public List<Message> getMessageByC(String sql) {
		List<Message> messages = new ArrayList<Message>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			String finalsql = null;
			if(sql.equals("")){
				finalsql = SEARCH_MESSAGE_SQL;
			}else{
				finalsql = SEARCH_MESSAGE_SQL + " WHERE "+sql;
			}
			rs=stmt.executeQuery(finalsql);
			while(rs.next()){
				Message message=new Message();
				message.setUserid(rs.getString("userid"));
				message.setMessageid(rs.getString("messageid"));
				message.setMessagetext(rs.getString("messagetext"));
				message.setMessagetime(rs.getDate("messagetime"));
				messages.add(message);								
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return messages;
	}

}
