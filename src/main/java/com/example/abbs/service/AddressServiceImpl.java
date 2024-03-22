package com.example.abbs.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.abbs.dao.AddressDao;
import com.example.abbs.entity.Address;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

	@Override
	public List<String> findAddresses() {
		return addressDao.findAddresses();
	}

	@Override
	public void addAddress(String address) {
		addressDao.insertAddress(address);
		
	}

	@Override
	public void updateAddress(Long bid, String address) {
		addressDao.updateAddress(bid, address);
		
	}

	@Override
	public void deleteAddress(Long bid) {
		addressDao.deleteAddress(bid);
		
	}

}