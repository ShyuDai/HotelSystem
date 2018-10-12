package com.hs.dao;

import java.util.List;

import com.hs.entity.Customer;

public interface CustomerDaoGH {
	public boolean save(Customer customer);
	
	public boolean delete(Customer customer);
	
	public boolean update(Customer customer);
	
	public Customer getCustomerById(int customerId);
	
	public int getCustomerCount(int attruCode,String value);
	
	public List<Customer> getCustomersByPage(int pageNo,int pageSize,int attruCode,String value);
	
}
