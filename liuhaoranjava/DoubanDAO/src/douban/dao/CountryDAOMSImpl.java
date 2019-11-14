package douban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDAOMSImpl extends DAOBase implements CountryDAO{

	private static final String CREATE_COUNTRY_SQL="INSERT INTO Country VALUES(?,?)";
	@Override
	public void insertCountry(Country country) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(CREATE_COUNTRY_SQL);
			pstm.setString(1, country.getCountryid());
			pstm.setString(2, country.getCountryname());
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_COUNTRY_SQL="UPDATE Country SET countryid=? ,countryname=?  WHERE countryid=? ";
	@Override
	public void updateCountry(Country country,String countryid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(UPDATE_COUNTRY_SQL);
			pstm.setString(1, country.getCountryid());
			pstm.setString(2, country.getCountryname());
			pstm.setString(3, countryid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String DELETE_COUNTRY_SQL="DELETE FROM Country WHERE countryid=? ";
	@Override
	public void deleteCountry(String countryid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(DELETE_COUNTRY_SQL);
			pstm.setString(1, countryid);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String SEARCH_COUNTRY_SQL="SELECT * FROM Country";
	@Override
	public List<Country> getCountryByC(String sql) {
		List<Country> countries = new ArrayList<Country>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			String finalsql = null;
			if(sql.equals("")){
				finalsql = SEARCH_COUNTRY_SQL;
			}else{
				finalsql = SEARCH_COUNTRY_SQL + " WHERE "+sql;
			}
			rs=stmt.executeQuery(finalsql);
			while(rs.next()){
				Country country = new Country();
				country.setCountryid(rs.getString("countryid"));
				country.setCountryname(rs.getString("countryname"));
				countries.add(country);									
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return countries;
	}

	private static final String GET_COUNTRY_SQL="SELECT * FROM Country WHERE countryid=? ";
	@Override
	public Country getCountry(String countryid) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Country country = new Country();
		try{
			conn = getConnection();
			pstm = conn.prepareStatement(GET_COUNTRY_SQL);
			pstm.setString(1, countryid);
			rs=pstm.executeQuery();
			rs.next();
			country.setCountryid(rs.getString("countryid"));
			country.setCountryname(rs.getString("countryname"));			
			rs.close();
			pstm.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return country;
	}

}
