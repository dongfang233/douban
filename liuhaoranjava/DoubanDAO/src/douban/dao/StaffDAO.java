package douban.dao;

import java.util.List;

public interface StaffDAO {
	public void insertStaff(Staff staff);
	public void updateStaff(Staff staff,String staffid);
	public void deleteStaff(String staffid);
	public Staff getStaff(String staffid);
	public List<Staff> getStaffByC(String sql);
}
