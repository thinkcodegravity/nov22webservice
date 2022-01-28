package com.springdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
	
	@Autowired
	LoginRepo lr;
	public boolean checkUser(String userid,String pwd) {
		List<UsersEntity> dbRecords=lr.findByUidAndPwd(userid, pwd);
		if(dbRecords.size() > 0)
			return true;
		else
			return false;
	}
	
	public boolean register(String userid,String pwd) {
		UsersEntity ue=new UsersEntity(userid, pwd);
		lr.save(ue);
		return true;
	}
	public boolean unsubscribe(String userid) {
		UsersEntity ue=new UsersEntity(userid);
		lr.delete(ue);
		return true;
	}
}
