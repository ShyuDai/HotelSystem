package com.hs.service;

import java.util.List;

import com.hs.dao.CustomerDaoGH;
import com.hs.dao.impl.CustomerDaoImplGH;
import com.hs.entity.Customer;

public class CustomerServiceGH {
	private CustomerDaoGH dao=new CustomerDaoImplGH();
	public int getCustomerCount(int attruCode, String value) {
		return dao.getCustomerCount(attruCode, value);
	}
	
	public List<Customer> getCustomersByPage(int pageNo, int pageSize, int attruCode, String value) {
		return dao.getCustomersByPage(pageNo, pageSize, attruCode, value);
	}

}
