package blog.dao;

import java.sql.SQLException;
import java.util.List;

import blog.model.Blog;

public interface BlogDaoInterface {
	void insertBlog(Blog blog) throws SQLException;
	Blog selectBlog(int blogId);
	List<Blog> selectALLBlogs();
	void deleteBlog(int id) throws SQLException;
	void updateBlog(Blog blog) throws SQLException ,Exception;
	
	

}
