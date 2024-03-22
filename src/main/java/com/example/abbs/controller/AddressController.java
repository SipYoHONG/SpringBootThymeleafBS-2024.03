package com.example.abbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.abbs.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // 모든 주소 조회
    @GetMapping
    public ResponseEntity<List<String>> getAllAddresses() {
        List<String> addresses = addressService.findAddresses();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }
    
    // 주소 추가
    @PostMapping
    public ResponseEntity<Void> addAddress(@RequestBody String address) {
        addressService.addAddress(address);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // 주소 수정
    @PutMapping("/{bid}")
    public ResponseEntity<Void> updateAddress(@PathVariable Long bid, @RequestBody String address) {
        addressService.updateAddress(bid, address);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 주소 삭제
    @DeleteMapping("/{bid}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long bid) {
        addressService.deleteAddress(bid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/addresses")
    public String listAddresses(Model model) {
        List<String> addresses = addressService.findAddresses(); // 주소 데이터 조회
        model.addAttribute("addresses", addresses); // 모델에 주소 데이터 추가
        return "address/list"; // 템플릿 파일명 반환
    }
}