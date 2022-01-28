package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
		
	@Autowired
	LoginService ls; //null
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String checkCredential(@RequestParam("uid") String userid,
			@RequestParam("pwd")  String pwd) {
		boolean result=ls.checkUser(userid, pwd);
		if(result == true )
			return "welcome";
		else
			return "login failed";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String createUser(@RequestParam("uid") String userid,
			@RequestParam("pwd")  String pwd) {
		boolean result=ls.register(userid, pwd);
		if(result == true )
			return "registration complete";
		else
			return "registration failed";
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("uid") String userid
			) {
		boolean result=ls.unsubscribe(userid);
		if(result == true )
			return "unregistration complete";
		else
			return "unregistration failed";
	}
	
}