package douban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StaffDAOMSImpl extends DAOBase implements StaffDAO{

	private static final String CREATE_STAFF_SQL="INSERT INTO Staff VALUES(?,?,?)";
	@Override
	public void insertStaff(Staff staff) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(CREATE_STAFF_SQL);
			pstm.setString(1, staff.getStaffid());
			pstm.setString(2, staff.getName());
			pstm.setBytes(3, staff.getPicture());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String UPDATE_STAFF_SQL="UPDATE Staff SET staffid=? ,name=? ,picture=?  WHERE staffid=? ";
	@Override
	public void updateStaff(Staff staff, String staffid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_STAFF_SQL);
			pstm.setString(1, staff.getStaffid());
			pstm.setString(2, staff.getName());
			pstm.setBytes(3, staff.getPicture());
			pstm.setString(4, staffid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String DELETE_STAFF_SQL="DELETE FROM Staff WHERE staffid=? ";
	@Override
	public void deleteStaff(String staffid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(DELETE_STAFF_SQL);
			pstm.setString(1, staffid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String GET_STAFF_SQL="SELECT * FROM Staff WHERE staffid=? ";
	@Override
	public Staff getStaff(String staffid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Staff staff=new Staff();
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(GET_STAFF_SQL);
			pstm.setString(1, staffid);
			rs=pstm.executeQuery();
			rs.next();
			staff.setStaffid(rs.getString("staffid"));
			staff.setName(rs.getString("name"));
			staff.setPicture(rs.getBytes("picture"));
			rs.close();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return staff;
	}

	private static final String SEARCH_STAFF_SQL="SELECT * FROM Staff";
	@Override
	public List<Staff> getStaffByC(String sql) {
		List<Staff> staffs = new ArrayList<Staff>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			String finalsql = null;
			if(sql.equals("")){
				finalsql = SEARCH_STAFF_SQL;
			}else{
				finalsql = SEARCH_STAFF_SQL + " WHERE "+sql;
			}
			rs=stmt.executeQuery(finalsql);
			while(rs.next()){
				Staff staff=new Staff();
				staff.setStaffid(rs.getString("staffid"));
				staff.setName(rs.getString("name"));
				staff.setPicture(rs.getBytes("picture"));
				staffs.add(staff);						
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return staffs;
	}

}
