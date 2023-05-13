package com.Advanced.SE.Project.model.user;
import java.util.TreeMap;

public class UserDB {
	private TreeMap<String, User> users;
	private static UserDB userDB;
	private UserDB() {
		users = new TreeMap<>();
	}
	public static UserDB getInstance() {
		if(userDB == null) {
			userDB = new UserDB();
		}
		return userDB;
	}
	public boolean addUser(String email, String password) throws Exception{
		if(users.get(email) != null)
			throw new Exception("This email already exists!");
		users.put(email, new User(email, password));
		return true;
	}
	
	public User getUser(String email , String password) throws Exception {
		User user = users.get(email);
		if(user == null)
			throw new Exception("No user with such email!");
		if(!user.verifyPassword(password))
			throw new Exception("Wrong password!");
		return user;
	}
	public User getUser(String email) throws Exception {
		User user = users.get(email);
		if(user == null)
			throw new Exception("No user with such email!");
		return user;
	}
}
