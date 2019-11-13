package douban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AwardDAOMSImpl extends DAOBase implements AwardDAO{

	private static final String CREATE_AWARD_SQL="INSERT INTO Award VALUES(?,?)";
	@Override
	public void insertAward(Award award) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(CREATE_AWARD_SQL);
			pstm.setString(1, award.getAwardid());
			pstm.setString(2, award.getPrize());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_AWARD_SQL="UPDATE Award SET awardid=\'?\',prize=\'?\' WHERE awardid=\'?\'";
	@Override
	public void updateAward(Award award, String awardid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_AWARD_SQL);
			pstm.setString(1, award.getAwardid());
			pstm.setString(2, award.getPrize());
			pstm.setString(3, awardid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String DELETE_AWARD_SQL="DELETE FROM Award WHERE awardid=\'?\'";
	@Override
	public void deleteAward(String awardid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(DELETE_AWARD_SQL);
			pstm.setString(1, awardid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String GET_AWARD_SQL="SELECT * FROM Award WHERE awardid=\'?\'";
	@Override
	public Award getAward(String awardid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Award award = new Award();
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(GET_AWARD_SQL);
			pstm.setString(1, awardid);
			rs=pstm.executeQuery();
			rs.next();
			award.setAwardid(rs.getString("awardid"));
			award.setPrize(rs.getString("prize"));			
			rs.close();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return award;
	}

	private static final String SEARCH_AWARD_SQL="SELECT * FROM Award";
	@Override
	public List<Award> getAwardByC(String sql) {
		List<Award> awards = new ArrayList<Award>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			String finalsql = null;
			if(sql.equals("")){
				finalsql = SEARCH_AWARD_SQL;
			}else{
				finalsql = SEARCH_AWARD_SQL + " WHERE "+sql;
			}
			rs=stmt.executeQuery(finalsql);
			while(rs.next()){
				Award award = new Award();
				award.setAwardid(rs.getString("awardid"));
				award.setPrize(rs.getString("prize"));	
				awards.add(award);									
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return awards;
	}
	
}