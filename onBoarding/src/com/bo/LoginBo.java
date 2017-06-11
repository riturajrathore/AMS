package com.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.dao.LoginDao;

public class LoginBo {
	
	
	public Boolean validateUser(String uid, String passwd)
	{
		
				
		LoginDao loginDao = new LoginDao();
		HashMap<String, String> userfromDB = loginDao.getUserDetailDao(uid);
		System.out.println(uid + " ==  " +passwd);
		Iterator<String> iterator = userfromDB.keySet().iterator();
		String userid="",pass="";
		while (iterator.hasNext()) {
			userid = iterator.next();
			if(userid.trim().equals(uid.trim()) && userfromDB.get(userid).equals(passwd.trim()))
			{
				return true;
			}
		}
		return false;
		
	}

}
