package com.Advanced.SE.Project.model.user;

import java.util.TreeMap;

public class ActiveUsers {
	private TreeMap<String, User> activeUsers;
	private static ActiveUsers activeusers;
	private ActiveUsers(){
		activeUsers = new TreeMap<>();
	}
	public static ActiveUsers getInstance() {
		if(activeusers == null)
			activeusers = new ActiveUsers();
		return activeusers;
	}
	public void addUser(String ip, User user) {
		activeUsers.put(ip, user);
	}
	public User getUser(String ip){
		return activeUsers.get(ip);
	}
	public void removeUser(String ip) throws Exception {
		if(activeUsers.remove(ip) == null)
			throw new Exception("No signed in user with this ip address!");
	}
}