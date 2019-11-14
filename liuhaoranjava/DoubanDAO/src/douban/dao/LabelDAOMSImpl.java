package douban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LabelDAOMSImpl extends DAOBase implements LabelDAO{

	private static final String CREATE_LABEL_SQL="INSERT INTO Label VALUES(?,?)";
	@Override
	public void insertLabel(Label label) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(CREATE_LABEL_SQL);
			pstm.setString(1, label.getLabelid());
			pstm.setString(2, label.getLabelname());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private static final String UPDATE_LABEL_SQL="UPDATE Label SET labelid=? ,labelname=?  WHERE labelid=? ";
	@Override
	public void updateLabel(Label label, String labelid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_LABEL_SQL);
			pstm.setString(1, label.getLabelid());
			pstm.setString(2, label.getLabelname());
			pstm.setString(3, labelid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String DELETE_LABEL_SQL="DELETE FROM Label WHERE labelid=? ";
	@Override
	public void deleteLabel(String labelid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(DELETE_LABEL_SQL);
			pstm.setString(1, labelid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String GET_LABEL_SQL="SELECT * FROM Label WHERE labelid=? ";
	@Override
	public Label getLabel(String labelid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Label label=new Label();
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(GET_LABEL_SQL);
			pstm.setString(1, labelid);
			rs=pstm.executeQuery();
			rs.next();
			label.setLabelid(rs.getString("labelid"));
			label.setLabelname(rs.getString("labelname"));
			rs.close();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return label;
	}

	private static final String SEARCH_LABEL_SQL="SELECT * FROM Label";
	@Override
	public List<Label> getCountryByC(String sql) {
		List<Label> labels = new ArrayList<Label>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			String finalsql = null;
			if(sql.equals("")){
				finalsql = SEARCH_LABEL_SQL;
			}else{
				finalsql = SEARCH_LABEL_SQL + " WHERE "+sql;
			}
			rs=stmt.executeQuery(finalsql);
			while(rs.next()){
				Label label=new Label();
				label.setLabelid(rs.getString("labelid"));
				label.setLabelname(rs.getString("labelname"));
				labels.add(label);								
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return labels;
	}

}
