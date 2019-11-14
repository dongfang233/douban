package douban.dao;

import java.util.List;

public interface MessageDAO {
	public void insertMessage(Message message);
	public void updateMessage(Message message,String messageid);
	public void deleteMessage(String messageid);
	public Message getMessage(String messageid);
	public List<Message> getMessageByC(String sql);
}
