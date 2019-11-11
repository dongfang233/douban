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
}
