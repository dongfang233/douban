package douban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TypeesDAOMSImpl extends DAOBase implements TypeesDAO{

	private static final String CREATE_TYPEES_SQL="INSERT INTO Typees VALUES(?,?)";
	@Override
	public void insertTypees(Typees typees) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(CREATE_TYPEES_SQL);
			pstm.setString(1, typees.getTypeid());
			pstm.setString(2, typees.getTypename());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String UPDATE_TYPESS_SQL="UPDATE Typees SET typeid=\'?\',typename=\'?\' WHERE typeid=\'?\'";
	@Override
	public void updateTypees(Typees typees, String typeesid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_TYPESS_SQL);
			pstm.setString(1, typees.getTypeid());
			pstm.setString(2, typees.getTypename());
			pstm.setString(3, typeesid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String DELETE_TYPEES_SQL="DELETE FROM Typees WHERE typeid=\'?\'";
	@Override
	public void deleteTypees(String typeesid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(DELETE_TYPEES_SQL);
			pstm.setString(1, typeesid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String GET_TYPEES_SQL="SELECT * FROM Typees WHERE typeid=\'?\'";
	@Override
	public List<Typees> getTypees(String typeesid) {
		List<Typees> typees = new ArrayList<Typees>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(GET_TYPEES_SQL);
			pstm.setString(1, typeesid);
			rs=pstm.executeQuery();
			while(rs.next()){
				Typees type = new Typees();
				type.setTypeid(rs.getString("typeid"));
				type.setTypename(rs.getString("typename"));
				typees.add(type);				
			}
			rs.close();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return typees;
	}

	private static final String SEARCH_TYPEES_SQL="SELECT * FROM Typees";
	@Override
	public List<Typees> getTypeesByC(String sql) {
		List<Typees> typees = new ArrayList<Typees>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			String finalsql = null;
			if(sql.equals("")){
				finalsql = SEARCH_TYPEES_SQL;
			}else{
				finalsql = SEARCH_TYPEES_SQL + " WHERE "+sql;
			}
			rs=stmt.executeQuery(finalsql);
			while(rs.next()){
				Typees type = new Typees();
				type.setTypeid(rs.getString("typeid"));
				type.setTypename(rs.getString("typename"));
				typees.add(type);								
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return typees;
	}

}
