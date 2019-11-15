package douban.dao;

import java.util.List;

public interface CommentDAO {
	public void insertComment(Comment comment);
	public void updateComment(Comment comment,String movieid,String userid);
	public void deleteComment(String movieid,String userid);
	public Comment getComment(String movieid,String userid);
	public List<Comment> getCommentByC(String sql);
	public int showAvgStar(String moviename);
}
