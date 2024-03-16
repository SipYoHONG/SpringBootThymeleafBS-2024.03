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
    public List<Address> findAll() {
        return addressDao.findAll();
    }

    @Override
    public void insert(Address address) {
        addressDao.insert(address);
    }

    @Override
    public void update(Address address) {
        addressDao.update(address);
    }

    @Override
    public Address findById(Long bid) {
        return addressDao.findById(bid).orElse(null);
    }
}