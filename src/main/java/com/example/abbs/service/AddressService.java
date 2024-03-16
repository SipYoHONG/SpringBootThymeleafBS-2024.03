package com.example.abbs.service;

import com.example.abbs.entity.Address;
import java.util.List;

public interface AddressService {
	
    List<Address> findAll();
    
    void insert(Address address);
    
    void update(Address address);
    
    Address findById(Long bid);
}