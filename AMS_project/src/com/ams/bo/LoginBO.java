package com.ams.bo;

import com.ams.dao.LoginDAO;
import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;
import com.ams.vo.LoginVO;

public class LoginBO 
{
	public boolean decrypt(LoginVO logVO)
	{
		char[] passHolder=logVO.getEncryptedPass().toCharArray();
		char[] processArray=new char[logVO.getEncryptedPass().length()];
		char secret[] = { 22, 53, 44, 71, 66, 177, 253, 122, 4, 14, 39, 420 }; //Password length should be within of length 12 
		int i;
		for(i = 0; i < processArray.length; i++)
		        {
				processArray[i]=passHolder[i];
		    	processArray[i] ^= secret[i];
		        }
		String temp=new String(processArray);
	    if(temp.equals(logVO.getPassword()))
	    {
	    	return true;
	    }
	    else
	    	return false;
	}
	
	
	public boolean ValidUser(LoginVO loginVo)throws AMSException,AMSBusinessException
	{
		LoginDAO loginDao = new LoginDAO();
		if(loginVo.getLoginName().isEmpty() || loginVo.getPassword().isEmpty())
		{
			throw new AMSBusinessException("User_name and password cannot be empty...!!");
		}
		else
		{
			loginVo.setEncryptedPass(loginDao.loginPassword(loginVo));
			if(!(loginDao.loginUser(loginVo).equals(loginVo.getLoginName())&&(decrypt(loginVo))))
			{
				throw new AMSBusinessException("Invalid UserName or Password");
			}
			else
			{
				return true;
			}
		}
	}
}
