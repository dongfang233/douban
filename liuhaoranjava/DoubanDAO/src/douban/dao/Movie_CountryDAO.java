package douban.dao;

import java.util.List;

public interface Movie_CountryDAO {
	public void insertMovie_Country(Movie_Country movie_country);
	public void updateMovie_Country(Movie_Country movie_country,String movieid,String countryid);
	public void deleteMovie_Country(String movieid,String countryid);
	public List<Movie_Country> getMovie_CountryByC(String sql);
}