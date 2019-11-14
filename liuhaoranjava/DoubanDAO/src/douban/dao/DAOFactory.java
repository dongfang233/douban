package douban.dao;

public class DAOFactory {
	private static DAOFactory instance;	
	static{
		instance = new DAOFactory();
	}	
	private DAOFactory(){
	}	
	public static DAOFactory getInstance(){
		return instance;
	}
	public static UserDAO getUserDAO() {
		UserDAO userDAO=new UserDAOMSImpl();
		return userDAO;
	}
	public static MovieDAO getMovieDAO() {
		MovieDAO movieDAO=new MovieDAOMSImpl();
		return movieDAO;
	}
	public static AwardDAO getAwardDAO() {
		AwardDAO awardDAO=new AwardDAOMSImpl();
		return awardDAO;
	}
	public static CommentDAO getCommentDAO() {
		CommentDAO commentDAO=new CommentDAOMSImpl();
		return commentDAO;
	}
	public static CountryDAO getCountryDAO() {
		CountryDAO countryDAO=new CountryDAOMSImpl();
		return countryDAO;
	}
	public static DiscussDAO getDiscussDAO() {
		DiscussDAO discussDAO=new DiscussDAOMSImpl();
		return discussDAO;
	}
	public static LabelDAO getLabelDAO() {
		LabelDAO labelDAO=new LabelDAOMSImpl();
		return labelDAO;
	}
	public static Movie_AwardDAO getMovie_AwardDAO() {
		Movie_AwardDAO movie_AwardDAO=new Movie_AwardDAOMSImpl();
		return movie_AwardDAO;
	}
	public static Movie_CountryDAO getMovie_CountryDAO() {
		Movie_CountryDAO movie_CountryDAO=new Movie_CountryDAOMSImpl();
		return movie_CountryDAO;
	}
	public static Movie_LabelDAO getMovie_LabelDAO() {
		Movie_LabelDAO movie_LabelDAO=new Movie_LabelDAOMSImpl();
		return movie_LabelDAO;
	}
	public static Movie_StaffDAO getMovie_StaffDAO() {
		Movie_StaffDAO movie_StaffDAO=new Movie_StaffDAOMSImpl();
		return movie_StaffDAO;
	}
	public static Movie_TypeesDAO getMovie_TypeesDAO() {
		Movie_TypeesDAO movie_TypeesDAO=new Movie_TypeesDAOMSImpl();
		return movie_TypeesDAO;
	}
	public static StaffDAO getStaffDAO() {
		StaffDAO staffDAO=new StaffDAOMSImpl();
		return staffDAO;
	}
	public static TypeesDAO getTypeesDAO() {
		TypeesDAO typeesDAO=new TypeesDAOMSImpl();
		return typeesDAO;
	}
	
	
	
}
