package douban.dao;

import java.util.List;

public interface CountryDAO {
	public void insertCountry(Country country);
	public void updateCountry(Country country,String countryid);
	public void deleteCountry(String countryid);
	public Country getCountry(String countryid);
	public List<Country> getCountryByC(String sql);
}
