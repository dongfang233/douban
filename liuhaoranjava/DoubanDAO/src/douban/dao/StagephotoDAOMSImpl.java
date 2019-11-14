package douban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StagephotoDAOMSImpl extends DAOBase implements StagephotoDAO{

	private static final String CREATE_STAGEPHOTO_SQL="INSERT INTO Stagephoto VALUES(?,?)";
	@Override
	public void insertStagephoto(Stagephoto stagephoto) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(CREATE_STAGEPHOTO_SQL);
			pstm.setString(1, stagephoto.getStagephotoid());
			pstm.setBytes(2, stagephoto.getStagephotopicture());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String UPDATE_STAGEPHOTO_SQL="UPDATE Stagephoto SET stagephotoid=?,stagephotopicture=? WHERE stagephotoid=?";
	@Override
	public void updateStagephoto(Stagephoto stagephoto, String stagephotoid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_STAGEPHOTO_SQL);
			pstm.setString(1, stagephoto.getStagephotoid());
			pstm.setBytes(2, stagephoto.getStagephotopicture());
			pstm.setString(3, stagephotoid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String DELETE_STAGEPHOTO_SQL="DELETE FROM Stagephoto WHERE stagephotoid=?";
	@Override
	public void deleteStagephoto(String stagephotoid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(DELETE_STAGEPHOTO_SQL);
			pstm.setString(1, stagephotoid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String GET_STAGEPHOTO_SQL="SELECT * FROM Stagephoto WHERE stagephotoid=?";
	@Override
	public Stagephoto getStagephoto(String stagephotoid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Stagephoto stagephoto = new Stagephoto();
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(GET_STAGEPHOTO_SQL);
			pstm.setString(1, stagephotoid);
			rs=pstm.executeQuery();
			rs.next();
			stagephoto.setStagephotoid(rs.getString("stagephotoid"));
			stagephoto.setStagephotopicture(rs.getBytes("stagephotopicture"));		
			rs.close();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return stagephoto;
	}

	private static final String SEARCH_STAGEPHOTO_SQL="SELECT * FROM Award";
	@Override
	public List<Stagephoto> getStagephotoByC(String sql) {
		List<Stagephoto> stagephotos = new ArrayList<Stagephoto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			String finalsql = null;
			if(sql.equals("")){
				finalsql = SEARCH_STAGEPHOTO_SQL;
			}else{
				finalsql = SEARCH_STAGEPHOTO_SQL + " WHERE "+sql;
			}
			rs=stmt.executeQuery(finalsql);
			while(rs.next()){
				Stagephoto stagephoto = new Stagephoto();
				stagephoto.setStagephotoid(rs.getString("stagephotoid"));
				stagephoto.setStagephotopicture(rs.getBytes("stagephotopicture"));	
				stagephotos.add(stagephoto);									
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return stagephotos;
	}

}
