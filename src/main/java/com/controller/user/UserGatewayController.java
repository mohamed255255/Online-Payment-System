package com.Advanced.SE.Project.controller.user;

import com.Advanced.SE.Project.model.user.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
public class UserGatewayController {
	
	//Sign up, URL => user/signup/, Method => POST
	@PostMapping("user/signup/")
	public String signup(@RequestParam("Email") String email, @RequestParam("Password") String password){
		try {
			UserDB.getInstance().addUser(email, password);
		}catch(Exception e) {
			return e.getMessage();
		}
		return "Success!";
	}
	
	//Log in, URL => user/login/, Method => POST
	@PostMapping("user/login/")
	public String logIn(@RequestParam("Email") String email, @RequestParam("Password") String password , HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		try {
			User user = UserDB.getInstance().getUser(email, password);
			ActiveUsers.getInstance().addUser(ip, user);
		}catch(Exception e) {
			return e.getMessage();
		}
		return "Success!";
	}
	
	//Log out, URL => user/logout/, Method => POST
	@PostMapping("user/logout/")
	public String logOut(HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		try {
			ActiveUsers.getInstance().removeUser(ip);
		}catch(Exception e) {
			return e.getMessage();
		}
		return "Success!";
	}
}