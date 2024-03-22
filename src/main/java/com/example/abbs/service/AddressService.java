package com.example.abbs.service;

import java.util.List;

public interface AddressService {
	  	List<String> findAddresses();
	  	
	    void addAddress(String address);
	    
	    void updateAddress(Long bid, String address);
	    
	    void deleteAddress(Long bid);
	}