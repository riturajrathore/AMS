package com.ams.bo;

import com.ams.dao.ChooseHouseDAO;
import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;
import com.ams.vo.ChooseHouseVO;

public class ChooseHouseBO {

	public String searchFlat(ChooseHouseVO chHouseVO) throws AMSBusinessException, AMSException
	{
		ChooseHouseDAO houseDao = new ChooseHouseDAO();
		String flat_id =  houseDao.searchFlat(chHouseVO);
		return flat_id;
	}

}
