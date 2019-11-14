package douban.dao;

import java.util.List;

public interface LabelDAO {
	public void insertLabel(Label label);
	public void updateLabel(Label label,String labelid);
	public void deleteLabel(String labelid);
	public Label getLabel(String labelid);
	public List<Label> getLableByC(String sql);
}
