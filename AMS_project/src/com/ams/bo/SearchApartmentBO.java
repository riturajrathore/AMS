package com.ams.bo;

import java.util.List;

import com.ams.dao.SearchApartmentDAO;
import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;
import com.ams.vo.ApartmentVO;
import com.ams.vo.SearchApartmentVO;


public class SearchApartmentBO
{
	public List<ApartmentVO> SearchData(SearchApartmentVO searchVO) throws AMSBusinessException, AMSException
	{
		
		if(searchVO.getBlockID()==null) 	//Check atleast one checkbox is checked
		{
			throw new AMSBusinessException("Please Select Any one Block Variant");
		}
	
	if(searchVO.getMinimumRent()>=searchVO.getMaximumRent())
		{
			throw new AMSBusinessException("Minimum Rent should be less than Maximum Rent");
		}
				
	if(searchVO.getMinimumAdvance()>=searchVO.getMaximumAdvance())
	{
		throw new AMSBusinessException("Minimum Advance should be less than Maximum Rent");
	}
	
	return new SearchApartmentDAO().searchApartment(searchVO);
	}
}
