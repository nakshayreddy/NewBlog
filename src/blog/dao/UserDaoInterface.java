package blog.dao;

import blog.model.User;

public interface UserDaoInterface {
	int signup(User user);
	boolean loginUser(User user);

}
